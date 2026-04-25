package com.vitor.relational_database_library.services;

import com.vitor.relational_database_library.entites.Client;
import com.vitor.relational_database_library.entites.dto.ClientResponseDto;
import com.vitor.relational_database_library.entites.dto.CreateClientDto;
import com.vitor.relational_database_library.repositories.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClientService {

    private ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public UUID register(CreateClientDto dto){

        var entitu = new Client(
                null,
                dto.name(),
                dto.email(),
                dto.password(),
                null);

        var id = clientRepository.save(entitu);

        return id.getClienteId();
    }

    public List<ClientResponseDto> listClients(){
        return clientRepository.findAll()
                .stream()
                .map(client -> new ClientResponseDto(client.getName(), client.getEmail()))
                .toList();
    }

    public void delete(UUID id){
        clientRepository.deleteById(id);
    }
}
