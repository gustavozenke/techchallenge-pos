package com.fiap.techchallenge.usecase.repository.produtos;

import com.fiap.techchallenge.domain.model.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends MongoRepository<Cliente, String> {
    Optional<Cliente> findByCpf(String cpf);
}
