package com.fiap.techchallenge.service;

import com.fiap.techchallenge.model.produtos.Bebida;
import com.fiap.techchallenge.repository.BebidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BebidaService {

    @Autowired
    BebidaRepository bebidaRepository;

    public ResponseEntity<String> criarBebida(Bebida bebida) {
        try {
            if(buscarBebida(bebida.getNome()).getStatusCode().equals(HttpStatus.NOT_FOUND)) {
                bebidaRepository.save(
                        new Bebida(
                                bebida.getNome(),
                                bebida.getDescricao(),
                                bebida.getPreco(),
                                bebida.getTamanho()
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

    public ResponseEntity<Bebida> buscarBebida(String nome) {
        Optional<Bebida> bebidaData_ = bebidaRepository.findByNome(nome);
        if (bebidaData_.isPresent()) {
            return new ResponseEntity<>(bebidaData_.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
