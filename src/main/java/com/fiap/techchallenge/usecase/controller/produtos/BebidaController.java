package com.fiap.techchallenge.usecase.controller.produtos;

import com.fiap.techchallenge.domain.model.produtos.Bebida;
import com.fiap.techchallenge.domain.service.BebidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/bebida")
public class BebidaController {

    @Autowired
    BebidaService bebidaService;

    @PostMapping("/new")
    public ResponseEntity<String> criarBebida(@RequestBody Bebida bebida){
        try {
            return bebidaService.criarBebida(bebida);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
