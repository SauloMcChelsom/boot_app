package com.app.boot_app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;

import com.app.boot_app.dto.client.ClienteConverter;
import com.app.boot_app.dto.client.ClienteRequestDTO;
import com.app.boot_app.dto.client.ClienteResponseDTO;
import com.app.boot_app.model.User;
import com.app.boot_app.service.user.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<User>  createUser(@RequestBody User user) {
		  User savedUser = userService.save(user);
	      return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
	}

	@PostMapping("/add-user")
    public ClienteResponseDTO salvar(@RequestBody @Validated ClienteRequestDTO requestDTO) {
        User clienteSalvo = userService.save(new User(
			requestDTO.getId(),
            requestDTO.getName(),
            requestDTO.getPhone(),
			requestDTO.getCpf()
        ));

        return ClienteConverter.converter(clienteSalvo);
    }
	
	@GetMapping
	public ResponseEntity<List<User>>  getUserAll() {
		List<User> savedUser = userService.findAll();
	    return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
	}
	
	@GetMapping("id/{id}")
	public ResponseEntity<List<User>>  getUserId(@PathVariable("id") Long id) {
		List<User> userlist = new ArrayList<User>();
		User user = userService.findById(id);
		userlist.add(user);
	    return new ResponseEntity<>(userlist, HttpStatus.CREATED);
	}
	
	@GetMapping("cpf/{id}")
	public ResponseEntity<List<User>> getUserByCPF(@PathVariable("id") String cpf) {
		List<User> user = userService.findByCPF(cpf);
	    return new ResponseEntity<>(user, HttpStatus.CREATED);
	}
	
	@GetMapping("name/{id}")
	public ResponseEntity<List<User>> getUserByName(@PathVariable("id") String name) {
		List<User> user = userService.findByName(name);
	    return new ResponseEntity<>(user, HttpStatus.CREATED);
	}
	
	@GetMapping("phone/{id}")
	public ResponseEntity<List<User>> getUserByPhone(@PathVariable("id") String phone) {
		List<User> user = userService.findByPhone(phone);
	    return new ResponseEntity<>(user, HttpStatus.CREATED);
	}
}
