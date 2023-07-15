package com.app.boot_app.service.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.boot_app.exeception.ClienteExistenteException;
import com.app.boot_app.model.User;
import com.app.boot_app.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
    @Override
    public User save(User user) {
		if (this.userRepository.existCpf(user.getCpf())) {
            throw new ClienteExistenteException("Cliente Existente", user.getCpf());
        }
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
	public List<User> findByCPF(String value) {
		List<User> user = this.userRepository.findByCPF(value);
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
