package com.fiap.techchallenge.ports.out.adapters;

import com.fiap.techchallenge.domain.pedido.Pedido;
import com.fiap.techchallenge.domain.statemachine.EstadoPedido;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PedidoRepository extends MongoRepository<Pedido, String> {
    Optional<Pedido> findBySequencia(Long sequencia);
    List<Pedido> findAllByEstadoPedido(EstadoPedido estadoPedido);
}
