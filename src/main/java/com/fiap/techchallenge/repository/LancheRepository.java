package com.fiap.techchallenge.repository;

import com.fiap.techchallenge.model.produtos.Lanche;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LancheRepository extends MongoRepository<Lanche, String> {
    Optional<Lanche> findByNome(String nome);
}
