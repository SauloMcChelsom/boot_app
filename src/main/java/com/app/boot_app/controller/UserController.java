package com.app.boot_app.controller;

import java.util.ArrayList;
import java.util.List;
import static java.lang.String.format;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.validation.annotation.Validated;
import lombok.extern.slf4j.Slf4j;

import com.app.boot_app.dto.client.ClienteConverter;
import com.app.boot_app.dto.client.ClienteRequestDTO;
import com.app.boot_app.dto.client.ClienteResponseDTO;
import com.app.boot_app.model.User;
import com.app.boot_app.service.user.UserService;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping
    public ClienteResponseDTO save(@RequestBody @Validated ClienteRequestDTO requestDTO) {
        log.info(format("START: Registering a new user"));
		User clienteSalvo = userService.save(new User(
			requestDTO.getId(),
            requestDTO.getName(),
            requestDTO.getPhone(),
			requestDTO.getCpf()
        ));
		log.info(format("finished"));
        return ClienteConverter.converter(clienteSalvo);
    }
	
	@GetMapping
	public List<ClienteResponseDTO> getUserAll() {
		log.info(format("Searching all users"));
		List<User> userList = userService.findAll();
		log.info(format("finished"));
		return ClienteConverter.converter(userList);
	}
	
	@GetMapping("id/{id}")
	public List<ClienteResponseDTO> getUserById(@PathVariable("id") Long id) {
		log.info(format("Fetching user data by id = %s!", id.toString()));
		List<User> userList = new ArrayList<User>();
		User user = userService.findById(id);
		userList.add(user);
		log.info(format("finished"));
		return ClienteConverter.converter(userList);
	}
	
	@GetMapping("cpf/{cpf}")
	public List<ClienteResponseDTO> getUserByCPF(@PathVariable("cpf") String cpf) {
		log.info(format("Fetching user data by cpf= %s!", cpf));
		List<User> user = userService.findByCPF(cpf);
		log.info(format("finished"));
		return ClienteConverter.converter(user);
	}
	
	@GetMapping("name/{name}")
	public List<ClienteResponseDTO> getUserByName(@PathVariable("name") String name) {
		log.info(format("Searching user data by name = %s!", name));
		List<User> user = userService.findByName(name);
		log.info(format("finished"));
	    return ClienteConverter.converter(user);
	}
	
	@GetMapping("phone/{phone}")
	public List<ClienteResponseDTO> getUserByPhone(@PathVariable("phone") String phone) {
		log.info(format("Fetching user data by phone = %s!", phone));
		List<User> user = userService.findByPhone(phone);
		log.info(format("finished"));
	    return ClienteConverter.converter(user);
	}
}
