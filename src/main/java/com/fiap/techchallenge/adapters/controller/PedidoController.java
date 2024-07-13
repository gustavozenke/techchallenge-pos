package com.fiap.techchallenge.adapters.controller;

import com.fiap.techchallenge.domain.model.Pedido;
import com.fiap.techchallenge.domain.statemachine.EstadoPedido;
import com.fiap.techchallenge.domain.statemachine.EventoPedido;
import com.fiap.techchallenge.ports.in.PedidoUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    PedidoUseCase pedidoUseCase;

    @PostMapping
    public ResponseEntity<String> criarPedido(@RequestBody Pedido pedido) {
        try {
            return pedidoUseCase.criarPedido(pedido);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<Pedido> buscarPedido(@RequestParam("pedido") long sequencia) {
        try {
            return pedidoUseCase.buscarPedido(sequencia);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/status")
    public ResponseEntity listarPorPedido(@RequestParam("status") EstadoPedido estadoPedido) {
        try {
            return pedidoUseCase.listarPedidoPorEstado(estadoPedido);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/paymentstatus")
    public ResponseEntity listarStatusPedido(@RequestParam("pedido") long sequencia) {
        try {
            return pedidoUseCase.listarStatusPedido(sequencia);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/pay")
    public ResponseEntity<String> pagarPedido(@RequestParam("pedido") long sequencia) {
        try {
            return pedidoUseCase.atualizarEstadoPedido(sequencia, EventoPedido.PAGANDO);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/enviar")
    public ResponseEntity<String> receberPedido(@RequestParam("pedido") long sequencia) {
        try {
            return pedidoUseCase.atualizarEstadoPedido(sequencia, EventoPedido.ENVIANDO);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/preparar")
    public ResponseEntity<String> prepararPedido(@RequestParam("pedido") long sequencia) {
        try {
            return pedidoUseCase.atualizarEstadoPedido(sequencia, EventoPedido.PREPARANDO);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/finalizar")
    public ResponseEntity<String> finalizarPedido(@RequestParam("pedido") long sequencia) {
        try {
            return pedidoUseCase.atualizarEstadoPedido(sequencia, EventoPedido.FINALIZANDO);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/entregar")
    public ResponseEntity<String> entregarPedido(@RequestParam("pedido") long sequencia) {
        try {
            return pedidoUseCase.atualizarEstadoPedido(sequencia, EventoPedido.ENTREGANDO);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<Pedido>> listarPedidosEmAndamento() {
        try {
            return pedidoUseCase.listarPedidosEmAndamento();
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
