package com.fiap.techchallenge.ports.in.produtos;

import com.fiap.techchallenge.domain.produtos.sobremesa.Sobremesa;
import com.fiap.techchallenge.domain.produtos.sobremesa.SobremesaUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
