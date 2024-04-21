package com.fiap.techchallenge.controller;

import com.fiap.techchallenge.model.produtos.Lanche;
import com.fiap.techchallenge.service.LancheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/lanche")
public class LancheController {

    @Autowired
    LancheService lancheService;

    @PostMapping("/new")
    public ResponseEntity<String> criarLanche(@RequestBody Lanche lanche){
        try{
            return lancheService.criarLanche(lanche);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
