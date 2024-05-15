package com.fiap.techchallenge.domain.pedido;


import com.fiap.techchallenge.ports.out.adapters.PedidoRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class PedidoUseCase {

    @Autowired
    PedidoRepository pedidoRepository;

    public ResponseEntity<String> criarPedido(Pedido pedido) {
        try {
            pedidoRepository.save(new Pedido(
                    pedido.getEstadoPedido(),
                    pedido.getEstadoPagamento(),
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

    public long contador(){
        long contador = pedidoRepository.count();
        return contador + 1;
    }
}
