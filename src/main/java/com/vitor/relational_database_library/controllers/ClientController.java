package com.vitor.relational_database_library.controllers;

import com.vitor.relational_database_library.entites.Client;
import com.vitor.relational_database_library.entites.dto.CreateClientDto;
import com.vitor.relational_database_library.services.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URI;
import java.util.List;

@Controller
@RequestMapping("/v1/client")
public class ClientController {

    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public ResponseEntity<Client> registerClient(@RequestBody CreateClientDto dto){
        var clientId = clientService.register(dto);

        return ResponseEntity.created(URI.create("/v1/book/" + clientId.toString())).build();
    }

    @GetMapping
    public ResponseEntity<List<Client>> listAll(){
        List<Client> list = clientService.listClients();

        return ResponseEntity.ok().body(list);
    }
}
