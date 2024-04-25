package com.fiap.techchallenge.usecase.repository;

import com.fiap.techchallenge.domain.model.produtos.Bebida;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BebidaRepository extends MongoRepository<Bebida, String> {
    Optional<Bebida> findByNome(String nome);
}
