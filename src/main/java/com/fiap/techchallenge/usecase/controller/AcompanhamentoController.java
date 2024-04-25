package com.fiap.techchallenge.usecase.controller;

import com.fiap.techchallenge.domain.model.produtos.Acompanhamento;
import com.fiap.techchallenge.domain.service.AcompanhamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

}
