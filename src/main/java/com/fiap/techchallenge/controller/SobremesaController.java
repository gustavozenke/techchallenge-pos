package com.fiap.techchallenge.controller;

import com.fiap.techchallenge.model.produtos.Sobremesa;
import com.fiap.techchallenge.service.SobremesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/sobremesa")
public class SobremesaController {

    @Autowired
    SobremesaService sobremesaService;

    @PostMapping("/new")
    public ResponseEntity<String> criarSobremesa(@RequestBody Sobremesa sobremesa){
        try {
            return sobremesaService.criarSobremsa(sobremesa);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
