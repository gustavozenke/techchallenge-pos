package com.fiap.techchallenge.ports.out.adapters;

import com.fiap.techchallenge.domain.cliente.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends MongoRepository<Cliente, String> {
    Optional<Cliente> findByCpf(String cpf);
}
