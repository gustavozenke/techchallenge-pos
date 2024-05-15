package com.fiap.techchallenge.ports.in.produtos;

import com.fiap.techchallenge.domain.produtos.bebida.Bebida;
import com.fiap.techchallenge.domain.produtos.bebida.BebidaUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
