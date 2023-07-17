package com.app.boot_app.service.user;

import java.util.List;
import java.util.Optional;
import static java.lang.String.format;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import com.app.boot_app.model.User;
import com.app.boot_app.repository.UserRepository;
import com.app.boot_app.shared.exeception.NotFoundException;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
    @Override
    public User save(User user) {
		try {
			log.info(format("existe cpf = %s!", user.getCpf()));
			
            this.userRepository.existCpf(user.getCpf());
        } catch (Exception e) {
			 log.error(format("existe cpf = %s!", user.getCpf()));
			 log.error(format("Exception = %s!", e.getMessage()));
			throw new NotFoundException("O cliente com cpf existe!");
        }
		log.info(format("Sava um novo usuario!"));
        return this.userRepository.save(user);
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
