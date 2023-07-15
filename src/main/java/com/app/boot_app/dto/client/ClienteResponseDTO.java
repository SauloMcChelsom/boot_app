package com.app.boot_app.dto.client;

public class ClienteResponseDTO {

    private Long id;
	
    private String name;
    
    private String phone;

    private String cpf;

    public ClienteResponseDTO(Long id, String name, String phone, String cpf) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.cpf = cpf;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}