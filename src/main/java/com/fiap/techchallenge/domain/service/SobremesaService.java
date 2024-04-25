package com.fiap.techchallenge.domain.service;

import com.fiap.techchallenge.domain.model.produtos.Sobremesa;
import com.fiap.techchallenge.usecase.repository.produtos.SobremesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SobremesaService {

    @Autowired
    SobremesaRepository sobremesaRepository;

    public ResponseEntity<String> criarSobremsa(Sobremesa sobremesa) {
        try {
            if (buscarSobremesa(sobremesa.getNome()).getStatusCode().equals(HttpStatus.NOT_FOUND)) {
                sobremesaRepository.save(
                        new Sobremesa(
                                sobremesa.getNome(),
                                sobremesa.getDescricao(),
                                sobremesa.getPreco()
                        )
                );
                return new ResponseEntity<>(null, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(null, HttpStatus.CONFLICT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Sobremesa> buscarSobremesa(String nome) {
        Optional<Sobremesa> sobremesaData_ = sobremesaRepository.findByNome(nome);
        if (sobremesaData_.isPresent()) {
            return new ResponseEntity<>(sobremesaData_.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
