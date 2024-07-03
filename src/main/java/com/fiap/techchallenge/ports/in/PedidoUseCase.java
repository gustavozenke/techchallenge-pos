package com.fiap.techchallenge.ports.in;

import com.fiap.techchallenge.domain.model.Pedido;
import com.fiap.techchallenge.domain.statemachine.EstadoPedido;
import com.fiap.techchallenge.domain.statemachine.EventoPedido;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PedidoUseCase {
    ResponseEntity<String> criarPedido(Pedido pedido);

    ResponseEntity<Pedido> buscarPedido(long sequencia);

    ResponseEntity<String> pagarPedido(long sequencia);

    ResponseEntity<String> atualizarEstadoPedido(long sequencia, EventoPedido eventoPedido);

    ResponseEntity<List<Pedido>> listarPedidoEstado(EstadoPedido estadoPedido);

    ResponseEntity<String> listarStatusPedido(long sequencia);
}
