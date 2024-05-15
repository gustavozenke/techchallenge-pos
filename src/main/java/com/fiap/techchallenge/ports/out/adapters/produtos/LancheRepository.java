package com.fiap.techchallenge.ports.out.adapters.produtos;

import com.fiap.techchallenge.domain.produtos.lanche.Lanche;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LancheRepository extends MongoRepository<Lanche, String> {
    Optional<Lanche> findByNomeBanco(String nomeBanco);
}
