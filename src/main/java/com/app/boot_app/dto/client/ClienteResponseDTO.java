package com.app.boot_app.dto.client;

public class ClienteResponseDTO {

    private Long id;
	
    private String name;
    
    private String phone;

    private String cpf;

    public ClienteResponseDTO(Long id,  String cpf, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.cpf = cpf;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getCpf() {
        return cpf;
    }

    
}