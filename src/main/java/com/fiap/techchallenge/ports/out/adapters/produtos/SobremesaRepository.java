package com.fiap.techchallenge.ports.out.adapters.produtos;

import com.fiap.techchallenge.domain.produtos.sobremesa.Sobremesa;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SobremesaRepository extends MongoRepository<Sobremesa, String> {
    Optional<Sobremesa> findByNome(String nome);
}
