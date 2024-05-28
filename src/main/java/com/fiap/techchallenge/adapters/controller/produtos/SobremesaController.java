package com.fiap.techchallenge.adapters.controller.produtos;

import com.fiap.techchallenge.domain.model.produtos.Sobremesa;
import com.fiap.techchallenge.ports.in.produtos.sobremesa.SobremesaUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/sobremesa")
public class SobremesaController {

    @Autowired
    SobremesaUseCase sobremesaUseCase;

    @PostMapping("/new")
    public ResponseEntity<String> criarSobremesa(@RequestBody Sobremesa sobremesa){
        try {
            return sobremesaUseCase.criarSobremsa(sobremesa);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Sobremesa>> listarSobremesas(){
        try {
            return sobremesaUseCase.listarSobremesas();
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{nomeBanco}")
    public ResponseEntity<Sobremesa> buscarSobremesa(@PathVariable("nomeBanco") String nomeBanco){
        try {
            return sobremesaUseCase.buscarSobremesa(nomeBanco);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{nomeBanco}")
    public ResponseEntity atualizarSobremesa(@PathVariable("nomeBanco") String nomeBanco, @RequestBody Sobremesa sobremesa){
        try {
            return sobremesaUseCase.atualizarSobremesa(nomeBanco, sobremesa);
        } catch (Exception e) {
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{nomeBanco}")
    public ResponseEntity apagarSobremesa(@PathVariable("nomeBanco") String nomeBanco){
        try {
            return sobremesaUseCase.apagarSobremesa(nomeBanco);
        } catch (Exception e) {
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
