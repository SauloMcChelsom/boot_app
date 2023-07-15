package com.app.boot_app.service.user;
import java.util.List;

import com.app.boot_app.model.User;


public interface UserService {

	User save(User user);
	List<User> findAll();
	User findById(Long value);
	List<User> findByCPF(String value);
	List<User> findByName(String value);
	List<User> findByPhone(String value);
}
