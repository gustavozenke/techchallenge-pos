package com.fiap.techchallenge.ports.in;

import com.fiap.techchallenge.domain.pedido.Pedido;
import com.fiap.techchallenge.domain.pedido.PedidoUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    PedidoUseCase pedidoUseCase;

    @PostMapping("/new")
    public ResponseEntity<String> criarPedido(@RequestBody Pedido pedido) {
        try {
            return pedidoUseCase.criarPedido(pedido);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //TODO fazer update

    @GetMapping("/pay/{pedido}")
    public ResponseEntity<String> pagarPedido(@PathVariable("pedido") Long sequencia){
        try {
            return pedidoUseCase.pagarPedido(sequencia);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
