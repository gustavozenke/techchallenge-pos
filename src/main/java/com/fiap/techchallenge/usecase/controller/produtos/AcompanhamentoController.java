package com.fiap.techchallenge.usecase.controller.produtos;

import com.fiap.techchallenge.domain.model.produtos.Acompanhamento;
import com.fiap.techchallenge.domain.service.AcompanhamentoService;
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
    AcompanhamentoService acompanhamentoService;

    @PostMapping("/new")
    public ResponseEntity<String> criarAcompanhamento(@RequestBody Acompanhamento acompanhamento){
        try {
            return acompanhamentoService.criarAcompanhamento(acompanhamento);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Acompanhamento>> listarAcompanhamentos(){
        try {
            return acompanhamentoService.listarAcompanhamentos();
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{nomeBanco}")
    public ResponseEntity<Acompanhamento> buscarAcompanhamento(@PathVariable("nomeBanco") String nomeBanco){
        try {
            return acompanhamentoService.buscarAcompanhamento(nomeBanco);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{nomeBanco}")
    public ResponseEntity apagarAcompanhamento(@PathVariable("nomeBanco") String nomeBanco){
        try {
            return acompanhamentoService.apagarAcompanhamento(nomeBanco);
        } catch (Exception e) {
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
