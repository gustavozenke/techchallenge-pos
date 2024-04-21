package com.fiap.techchallenge.repository;

import com.fiap.techchallenge.model.produtos.Sobremesa;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SobremesaRepository extends MongoRepository<Sobremesa, String> {
    Optional<Sobremesa> findByNome(String nome);
}
