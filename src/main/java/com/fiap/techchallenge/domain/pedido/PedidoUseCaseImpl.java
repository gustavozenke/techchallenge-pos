package com.fiap.techchallenge.domain.pedido;


import com.fiap.techchallenge.domain.statemachine.EstadoPedido;
import com.fiap.techchallenge.domain.statemachine.EventoPedido;
import com.fiap.techchallenge.ports.out.adapters.PedidoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineFactory;
import org.springframework.statemachine.support.DefaultStateMachineContext;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Log4j2
@Service
@RequiredArgsConstructor
public class PedidoUseCaseImpl implements PedidoUseCase {

    static String SEQUENCIA;

    @Autowired
    PedidoRepository pedidoRepository;

    private final StateMachineFactory<EstadoPedido, EventoPedido> stateMachineFactory;

    public ResponseEntity<String> criarPedido(Pedido pedido) {
        try {
            long contador = contador();
            pedidoRepository.save(new Pedido(
                            contador,
                            pedido.getCliente(),
                            pedido.getLanches(),
                            pedido.getBebidas(),
                            pedido.getSobremesas(),
                            pedido.getAcompanhamentos()
                    )
            );
            log.info("pedido {} criado", contador);
            return new ResponseEntity<>("pedido " + contador + " criado", HttpStatus.CREATED);
        } catch (Exception e) {
            log.error(e.toString());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private long contador() {
        long contador = pedidoRepository.count();
        return contador + 1;
    }

    public ResponseEntity<Pedido> buscarPedido(long sequencia) {
        Optional<Pedido> pedidoData_ = pedidoRepository.findBySequencia(sequencia);
        if (pedidoData_.isPresent()) {
            return new ResponseEntity<>(pedidoData_.get(), HttpStatus.OK);
        } else {
            log.warn("pedido {} não encontrado", sequencia);
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<String> pagarPedido(long sequencia) {
        StateMachine<EstadoPedido, EventoPedido> stateMachine = build(sequencia);

        Optional<Pedido> pedidoData_ = pedidoRepository.findBySequencia(sequencia);
        if (pedidoData_.isPresent()) {
            pedidoData_.get().setEstadoPedido(EstadoPedido.PAGO);
            pedidoRepository.save(pedidoData_.get());
            sendEvent(sequencia, stateMachine, EventoPedido.PAGANDO);
            log.info("pedido {} pago", sequencia);
            return new ResponseEntity<>("Pedido " + sequencia + " " + pedidoData_.get().getEstadoPedido().toString(), HttpStatus.OK);
        } else {
            log.error("pedido {} não encontrado", sequencia);
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<String> atualizarEstadoPedido(long sequencia, EventoPedido eventoPedido){
        StateMachine<EstadoPedido, EventoPedido> stateMachine = build(sequencia);
        Optional<Pedido> pedidoData_ = pedidoRepository.findBySequencia(sequencia);
        if (pedidoData_.isPresent()) {
            sendEvent(sequencia, stateMachine, eventoPedido);
            pedidoData_.get().setEstadoPedido(stateMachine.getState().getId());
            pedidoRepository.save(pedidoData_.get());
            log.info("Pedido " + sequencia + " " + pedidoData_.get().getEstadoPedido().toString());
            return new ResponseEntity<>("Pedido " + sequencia + " " + pedidoData_.get().getEstadoPedido().toString(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<List<Pedido>> listarPedidoEstado(EstadoPedido estadoPedido) {
        List<Pedido> pedidos = pedidoRepository.findAllByEstado(estadoPedido);
        return new ResponseEntity<>(pedidos, HttpStatus.OK);
    }

    private void sendEvent(long sequencia, StateMachine<EstadoPedido, EventoPedido> stateMachine, EventoPedido eventoPedido){
        Message mensagem = MessageBuilder.withPayload(eventoPedido)
                .setHeader(SEQUENCIA, sequencia)
                .build();
        stateMachine.sendEvent(mensagem);
    }

    private StateMachine<EstadoPedido, EventoPedido> build(Long sequencia){
        Optional<Pedido> pedidoData_ = pedidoRepository.findBySequencia(sequencia);
        StateMachine<EstadoPedido, EventoPedido> stateMachine = stateMachineFactory.getStateMachine(String.valueOf(pedidoData_.get().getId()));
        stateMachine.stop();
        stateMachine.getStateMachineAccessor().doWithAllRegions(stateMachineAccessor -> {
            stateMachineAccessor.resetStateMachine(new DefaultStateMachineContext<>(pedidoData_.get().getEstadoPedido(),null,null,null));
        });
        stateMachine.start();
        return stateMachine;
    }

}
