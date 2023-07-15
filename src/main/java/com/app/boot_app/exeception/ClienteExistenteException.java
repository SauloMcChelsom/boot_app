package com.app.boot_app.exeception;

public class ClienteExistenteException extends RuntimeException{
    private final String cpf;

    public ClienteExistenteException(String message, String cpf) {
        super(message);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }
}