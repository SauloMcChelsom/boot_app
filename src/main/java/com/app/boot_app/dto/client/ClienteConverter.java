package com.app.boot_app.dto.client;

import com.app.boot_app.model.User;

public class ClienteConverter {

    public static ClienteResponseDTO converter(User originalCliente) {
        return new ClienteResponseDTO(
            originalCliente.getId(),
            originalCliente.getCpf(),
            originalCliente.getName(),
            originalCliente.getPhone()
        );
    }

}
