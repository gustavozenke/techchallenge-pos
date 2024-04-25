package com.fiap.techchallenge.usecase.repository;

import com.fiap.techchallenge.domain.model.produtos.Acompanhamento;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AcompanhamentoRepository extends MongoRepository<Acompanhamento, String> {
    Optional<Acompanhamento> findByNome(String nome);
}
