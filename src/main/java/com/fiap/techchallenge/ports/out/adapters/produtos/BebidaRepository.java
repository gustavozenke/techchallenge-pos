package com.fiap.techchallenge.ports.out.adapters.produtos;

import com.fiap.techchallenge.domain.produtos.bebida.Bebida;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BebidaRepository extends MongoRepository<Bebida, String> {
    Optional<Bebida> findByNomeBanco(String nomeBanco);
}
