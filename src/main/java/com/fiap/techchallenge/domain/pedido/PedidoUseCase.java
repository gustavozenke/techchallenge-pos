package com.fiap.techchallenge.domain.pedido;


import com.fiap.techchallenge.ports.out.adapters.PedidoRepository;
import com.fiap.techchallenge.statemachine.EstadoPedido;
import com.fiap.techchallenge.statemachine.EventoPedido;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.statemachine.StateMachine;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Log4j2
@Service
public class PedidoUseCase {

    @Autowired
    private StateMachine<EstadoPedido, EventoPedido> stateMachine;

    @Autowired
    PedidoRepository pedidoRepository;

    public ResponseEntity<String> criarPedido(Pedido pedido) {
        try {
            pedidoRepository.save(new Pedido(
                    contador(),
                    pedido.getCliente(),
                    pedido.getLanches(),
                    pedido.getBebidas(),
                    pedido.getSobremesas(),
                    pedido.getAcompanhamentos()
                )
            );
            log.info("pedido criado");
            return new ResponseEntity<>(null, HttpStatus.CREATED);
        } catch (Exception e) {
            log.error(e.toString());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public long contador() {
        long contador = pedidoRepository.count();
        return contador + 1;
    }

    public ResponseEntity<Pedido> buscarPedido(Long sequencia) {
        Optional<Pedido> pedidoData_ = pedidoRepository.findBySequencia(sequencia);
        if (pedidoData_.isPresent()) {
            return new ResponseEntity<>(pedidoData_.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<String> pagarPedido(Long sequencia) {
        Optional<Pedido> pedidoData_ = pedidoRepository.findBySequencia(sequencia);
        if (pedidoData_.isPresent()) {
            pedidoData_.get().setEstadoPedido(EstadoPedido.PAGO);
            pedidoRepository.save(pedidoData_.get());
            stateMachine.sendEvent(EventoPedido.PEDIDO_PAGO);
            return new ResponseEntity<>("Pedido "+ sequencia + " " + pedidoData_.get().getEstadoPedido().toString(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
