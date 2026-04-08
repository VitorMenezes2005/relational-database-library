package com.vitor.relational_database_library.repositories;

import com.vitor.relational_database_library.entites.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClientRepository extends JpaRepository<Client, UUID> {
}
