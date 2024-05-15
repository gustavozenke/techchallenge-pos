package com.fiap.techchallenge.ports.in.produtos;

import com.fiap.techchallenge.domain.produtos.acompanhamento.Acompanhamento;
import com.fiap.techchallenge.domain.produtos.acompanhamento.AcompanhamentoUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/acompanhamento")
public class AcompanhamentoController {

    @Autowired
    AcompanhamentoUseCase acompanhamentoUseCase;

    @PostMapping("/new")
    public ResponseEntity<String> criarAcompanhamento(@RequestBody Acompanhamento acompanhamento){
        try {
            return acompanhamentoUseCase.criarAcompanhamento(acompanhamento);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Acompanhamento>> listarAcompanhamentos(){
        try {
            return acompanhamentoUseCase.listarAcompanhamentos();
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{nomeBanco}")
    public ResponseEntity<Acompanhamento> buscarAcompanhamento(@PathVariable("nomeBanco") String nomeBanco){
        try {
            return acompanhamentoUseCase.buscarAcompanhamento(nomeBanco);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{nomeBanco}")
    public ResponseEntity apagarAcompanhamento(@PathVariable("nomeBanco") String nomeBanco){
        try {
            return acompanhamentoUseCase.apagarAcompanhamento(nomeBanco);
        } catch (Exception e) {
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
