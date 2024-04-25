package com.fiap.techchallenge.usecase.repository;

import com.fiap.techchallenge.domain.model.Pedido;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends MongoRepository<Pedido, String> {
}
