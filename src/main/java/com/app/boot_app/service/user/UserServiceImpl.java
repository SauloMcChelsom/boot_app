package com.app.boot_app.service.user;

import java.util.List;
import java.util.Optional;
import static java.lang.String.format;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import com.app.boot_app.model.User;
import com.app.boot_app.repository.UserRepository;
import com.app.boot_app.shared.exeception.BadRequestException;
import com.app.boot_app.shared.exeception.ConflictException;
import com.app.boot_app.shared.exeception.NotFoundException;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
    @Override
    public User save(User user) {
		log.info(format("call method ExistCPF()", user.getCpf()));
		if(this.ExistCPF(user) == true){
			log.info(format("The client with cpf "+user.getCpf()+" already exist"));
			throw new ConflictException("The client with cpf "+user.getCpf()+" already exist");
		}
			
		try {
			log.info(format("call repository save()"));
        	User savedUser = this.userRepository.save(user);

			log.info(format("user successfully saved"));
			return savedUser;

        } catch (Exception e) {
			log.error(format("Exception = %s!", e.getMessage()));
			throw new BadRequestException("Error in save user");
        }
    }

	private Boolean ExistCPF(User user) {
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
			throw new NotFoundException("Error in find "+ user.getCpf() +"");
        }
    }

	@Override
	public List<User> findAll() {
		 return this.userRepository.findAll();
	}

	@Override
	public User findById(Long id) {
		Optional<User> user = this.userRepository.findById(id);
		return user.get();
	}

	@Override
	public List<User> findByCPF(String cpf) {
		List<User> user = this.userRepository.findByCPF(cpf);
		return user;
	}

	@Override
	public List<User> findByName(String value) {
		List<User> user = this.userRepository.findByName(value);
		return user;
	}

	@Override
	public List<User> findByPhone(String value) {
		List<User> user = this.userRepository.findByPhone(value);
		return user;
	}

}
