package com.fiap.techchallenge.adapters.repository.produtos;

import com.fiap.techchallenge.domain.model.produtos.Lanche;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LancheRepository extends MongoRepository<Lanche, String> {
    Optional<Lanche> findByNomeBanco(String nomeBanco);
}
