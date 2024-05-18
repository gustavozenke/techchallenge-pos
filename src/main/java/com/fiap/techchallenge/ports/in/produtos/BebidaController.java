package com.fiap.techchallenge.ports.in.produtos;

import com.fiap.techchallenge.domain.produtos.bebida.Bebida;
import com.fiap.techchallenge.domain.produtos.bebida.BebidaUseCase;
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

    @PostMapping("/new")
    public ResponseEntity<String> criarBebida(@RequestBody Bebida bebida){
        try {
            return bebidaUseCase.criarBebida(bebida);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Bebida>> listarBebidas(){
        try {
            return bebidaUseCase.listarBebidas();
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{nomeBanco}")
    public ResponseEntity<Bebida> buscarBebida(@PathVariable("nomeBanco") String nomeBanco){
        try {
            return bebidaUseCase.buscarBebida(nomeBanco);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //TODO fazer updates

    @DeleteMapping("/{nomeBanco}")
    public ResponseEntity apagarBebida(@PathVariable("nomeBanco") String nomeBanco){
        try {
            return bebidaUseCase.apagarBebida(nomeBanco);
        } catch (Exception e) {
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
