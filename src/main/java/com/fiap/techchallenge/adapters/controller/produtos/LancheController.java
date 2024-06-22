package com.fiap.techchallenge.adapters.controller.produtos;

import com.fiap.techchallenge.domain.model.produtos.Lanche;
import com.fiap.techchallenge.ports.in.produtos.lanche.LancheUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/lanche")
public class LancheController {

    @Autowired
    LancheUseCase lancheUseCase;

    @PostMapping
    public ResponseEntity<String> criarLanche(@RequestBody Lanche lanche) {
        try {
            return lancheUseCase.criarLanche(lanche);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Lanche>> listarLanches() {
        try {
            return lancheUseCase.listarLanches();
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{nomeBanco}")
    public ResponseEntity<Lanche> buscarLanche(@PathVariable("nomeBanco") String nomeBanco) {
        try {
            return lancheUseCase.buscarLanche(nomeBanco);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{nomeBanco}")
    public ResponseEntity atualizarLanche(@PathVariable("nomeBanco") String nomeBanco, @RequestBody Lanche lanche) {
        try {
            return lancheUseCase.atualizarLanche(nomeBanco, lanche);
        } catch (Exception e) {
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{nomeBanco}")
    public ResponseEntity apagarLanche(@PathVariable("nomeBanco") String nomeBanco) {
        try {
            return lancheUseCase.apagarLanche(nomeBanco);
        } catch (Exception e) {
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
