package com.app.boot_app.service.user;

import java.util.ArrayList;
import java.util.List;
import static java.lang.String.format;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import com.app.boot_app.model.User;
import com.app.boot_app.repository.UserRepository;
import com.app.boot_app.shared.exeception.BadRequestException;
import com.app.boot_app.shared.exeception.ConflictException;
import com.app.boot_app.shared.exeception.InternalServerErrorException;
import com.app.boot_app.shared.exeception.NotFoundException;
import com.app.boot_app.shared.util.ValidationCPF;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
    @Override
    public User save(User user) {

		log.info(format("call method ValidationCPF()", user.getCpf()));
		boolean validCPF =  new ValidationCPF().CPF(user.getCpf());

		log.info(format("CPF is valid"));
		if(validCPF == false){
			log.info(format("The CPF "+user.getCpf()+" is not valid"));
			throw new BadRequestException("cpf is not valid");
		}

		log.info(format("call method ExistCPF()"));
		if(this.ExistCPF(user) == true){
			log.info(format("The client with cpf "+user.getCpf()+" already exist"));
			throw new ConflictException("cpf already exist");
		}
			
		try {
			log.info(format("call repository save()"));
        	User savedUser = this.userRepository.save(user);

			log.info(format("user successfully saved"));
			return savedUser;

        } catch (Exception e) {
			log.error(format("Exception = %s!", e.getMessage()));
			throw new InternalServerErrorException("error in save user");
        }
    }

	@Override
	public User findById(Long id) {
 		Boolean isExist = false;
		User user = null;

		try {
			log.info(format("call repository existsById()"));
            isExist = this.userRepository.existsById(id);

			log.info(format("if the user exists, set the values"));
			if(isExist){
				user = this.userRepository.findById(id).get();
			}

        } catch (Exception e) {
			log.error(format("Exception: %s!", e.getMessage()));
			throw new InternalServerErrorException("error in find user por id");
        }
		
		log.info(format("user exist"));
		if(isExist == false){
			log.info(format("user not exist"));
			throw new NotFoundException("user not exist");
		}

		log.info(format("user find with successful"));
		return user;
	}

	@Override
	public List<User> findByCPF(String cpf) {

		List<User> user = new ArrayList<User>();
		Boolean isExist = false;

		log.info(format("call method ValidationCPF()",cpf));
		boolean validCPF =  new ValidationCPF().CPF(cpf);

		log.info(format("CPF is valid"));
		if(validCPF == false){
			log.info(format("The CPF "+cpf+" is not valid"));
			throw new BadRequestException("cpf is not valid");
		}

		try {
			log.info(format("call repository existCpf()"));
            List<User> userExist = this.userRepository.findByCPF(cpf);

			if(userExist.isEmpty() == false){
				log.info(format("cpf exist"));
				user.add(userExist.get(0));
				isExist = true;
			}else{
				log.info(format("cpf not exist"));
				isExist =  false;
			}

        } catch (Exception e) {
			log.error(format("Exception: %s!", e.getMessage()));
			throw new InternalServerErrorException("error in find cpf");
        }


		log.info(format("cpf exist"));
		if(isExist == false){
			log.info(format("cpf not exist"));
			throw new NotFoundException("cpf not exist");
		}

		log.info(format("cpf find with successful"));
		return user;
	}

	@Override
	public List<User> findByName(String name) {
		List<User> user = new ArrayList<User>();
		Boolean isExist = false;

		try {
			log.info(format("call repository findByName()"));
			List<User> userExist = this.userRepository.findByName(name);

			if(userExist.isEmpty() == false){
				log.info(format("name exist"));
				user.add(userExist.get(0));
				isExist = true;
			}else{
				log.info(format("name not exist"));
				isExist =  false;
			}

        } catch (Exception e) {
			log.error(format("Exception: %s!", e.getMessage()));
			throw new InternalServerErrorException("error in find name");
        }

		log.info(format("name exist"));
		if(isExist == false){
			log.info(format("name not exist"));
			throw new NotFoundException("name not exist");
		}

		log.info(format("name find with successful"));
		
		return user;
	}

	@Override
	public List<User> findByPhone(String phone) {
		List<User> user = new ArrayList<User>();
		Boolean isExist = false;

		try {
			log.info(format("call repository findByPhone()"));
			List<User> userExist = this.userRepository.findByPhone(phone);

			if(userExist.isEmpty() == false){
				log.info(format("phone exist"));
				user.add(userExist.get(0));
				isExist = true;
			}else{
				log.info(format("phone not exist"));
				isExist =  false;
			}

        } catch (Exception e) {
			log.error(format("Exception: %s!", e.getMessage()));
			throw new InternalServerErrorException("error in find phone");
        }

		log.info(format("phone exist"));
		if(isExist == false){
			log.info(format("phone not exist"));
			throw new NotFoundException("phone not exist");
		}

		log.info(format("phone find with successful"));
		return user;
	}

	@Override
	public List<User> findAll() {
		return this.userRepository.findAll();
	}

	public Boolean ExistCPF(User user) {
		try {
			log.info(format("call repository existCpf()"));
            Iterable<User> userExist = this.userRepository.existCpf(user.getCpf());

			
			if(userExist.toString().length() > 2){
				log.info(format("user exist"));
				return true;
			}else{
				log.info(format("user not exist"));
				return false;
			}

        } catch (Exception e) {
			log.error(format("Exception: %s!", e.getMessage()));
			throw new InternalServerErrorException("error in find user");
        }
    }
}
