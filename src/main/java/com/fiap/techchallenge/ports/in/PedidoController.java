package com.fiap.techchallenge.ports.in;

import com.fiap.techchallenge.domain.pedido.Pedido;
import com.fiap.techchallenge.domain.pedido.PedidoUseCase;
import com.fiap.techchallenge.domain.statemachine.EventoPedido;
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
    public ResponseEntity<String> pagarPedido(@PathVariable("pedido") long sequencia){
        try {
            return pedidoUseCase.pagarPedido(sequencia);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{pedido}/receber")
    public ResponseEntity<String> receberPedido(@PathVariable("pedido") long sequencia){
        try {
            return pedidoUseCase.atualizarEstadoPedido(sequencia, EventoPedido.ENVIANDO);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{pedido}/preparar")
    public ResponseEntity<String> prepararPedido(@PathVariable("pedido") long sequencia){
        try {
            return pedidoUseCase.atualizarEstadoPedido(sequencia, EventoPedido.PREPARANDO);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{pedido}/finalizar")
    public ResponseEntity<String> finalizarPedido(@PathVariable("pedido") long sequencia){
        try {
            return pedidoUseCase.atualizarEstadoPedido(sequencia, EventoPedido.FINALIZANDO);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{pedido}/entregar")
    public ResponseEntity<String> entregarPedido(@PathVariable("pedido") long sequencia){
        try {
            return pedidoUseCase.atualizarEstadoPedido(sequencia, EventoPedido.ENTREGANDO);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
