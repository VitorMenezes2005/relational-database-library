package com.vitor.relational_database_library.controllers;

import com.vitor.relational_database_library.entites.Client;
import com.vitor.relational_database_library.entites.dto.ClientResponseDto;
import com.vitor.relational_database_library.entites.dto.CreateClientDto;
import com.vitor.relational_database_library.services.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/client")
@Tag(name = "Cliente", description = "Gerenciador de clientes")
public class ClientController {

    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    @Operation(summary = "Registrar um novo cliente", description = "Registra um novo cliente a partir do preenchimento de um DTO")
    public ResponseEntity<Client> registerClient(@RequestBody CreateClientDto dto){
        var clientId = clientService.register(dto);

        return ResponseEntity.created(URI.create("/v1/book/" + clientId.toString())).build();
    }

    @GetMapping
    @Operation(summary = "Listar todos os clientes", description = "Lista todos os clientes cadastrados no banco de dados")
    public ResponseEntity<List<ClientResponseDto>> listAll(){
        List<ClientResponseDto> list = clientService.listClients();

        return ResponseEntity.ok().body(list);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar um cliente", description = "Deleta um cliente do banco de dados a partir do id dele")
    public ResponseEntity<Void> deletedById(@PathVariable UUID id){
        clientService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
