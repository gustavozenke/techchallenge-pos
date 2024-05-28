package com.fiap.techchallenge.adapters.repository.produtos;

import com.fiap.techchallenge.domain.model.produtos.Sobremesa;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SobremesaRepository extends MongoRepository<Sobremesa, String> {
    Optional<Sobremesa> findByNomeBanco(String nomeBanco);
}
