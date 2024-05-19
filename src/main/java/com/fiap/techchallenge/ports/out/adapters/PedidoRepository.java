package com.fiap.techchallenge.ports.out.adapters;

import com.fiap.techchallenge.domain.pedido.Pedido;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PedidoRepository extends MongoRepository<Pedido, String> {
    Optional<Pedido> findBySequencia(Long sequencia);
}
