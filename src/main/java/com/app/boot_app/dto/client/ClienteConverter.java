package com.app.boot_app.dto.client;

import java.util.ArrayList;
import java.util.List;

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

    public static List<ClienteResponseDTO> converter(List<User> User) {
        List<ClienteResponseDTO> clienteResponseDTO = new ArrayList<ClienteResponseDTO>();

        for (User user : User) {
            clienteResponseDTO.add(
                new ClienteResponseDTO(
                    user.getId(),
                    user.getCpf(),
                    user.getName(),
                    user.getPhone()
                )
            );
        }

        return clienteResponseDTO;
    }

}
