package com.fiap.techchallenge.ports.in.produtos;

import com.fiap.techchallenge.domain.produtos.lanche.Lanche;
import com.fiap.techchallenge.domain.produtos.lanche.LancheUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/lanche")
public class LancheController {

    @Autowired
    LancheUseCase lancheUseCase;

    @PostMapping("/new")
    public ResponseEntity<String> criarLanche(@RequestBody Lanche lanche){
        try {
            return lancheUseCase.criarLanche(lanche);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
