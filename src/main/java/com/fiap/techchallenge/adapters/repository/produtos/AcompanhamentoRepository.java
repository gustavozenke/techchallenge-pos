package com.fiap.techchallenge.adapters.repository.produtos;

import com.fiap.techchallenge.domain.model.produtos.Acompanhamento;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AcompanhamentoRepository extends MongoRepository<Acompanhamento, String> {
    Optional<Acompanhamento> findByNomeBanco(String nomeBanco);
}
