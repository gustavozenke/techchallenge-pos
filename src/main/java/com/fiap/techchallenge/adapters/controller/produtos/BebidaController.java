package com.fiap.techchallenge.adapters.controller.produtos;

import com.fiap.techchallenge.domain.model.produtos.Bebida;

import com.fiap.techchallenge.ports.in.produtos.BebidaUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/bebida")
public class BebidaController {

    @Autowired
    BebidaUseCase bebidaUseCase;

    @PostMapping
    public ResponseEntity<String> criarBebida(@RequestBody Bebida bebida) {
        try {
            return bebidaUseCase.criarBebida(bebida);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Bebida>> listarBebidas() {
        try {
            return bebidaUseCase.listarBebidas();
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<Bebida> buscarBebidaNome(@RequestParam("nome") String nome) {
        try {
            return bebidaUseCase.buscarBebida(nome);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping
    public ResponseEntity<Bebida> atualizarBebidas(@RequestParam("nome") String nome, @RequestBody Bebida bebida) {
        try {
            return bebidaUseCase.atualizarBebida(nome, bebida);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping
    public ResponseEntity<String> apagarBebida(@RequestParam("nome") String nomeBanco) {
        try {
            return bebidaUseCase.apagarBebida(nomeBanco);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
