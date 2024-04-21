package com.fiap.techchallenge.service;

import com.fiap.techchallenge.model.produtos.Lanche;
import com.fiap.techchallenge.repository.LancheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LancheService {

    @Autowired
    LancheRepository lancheRepository;

    public ResponseEntity<String> criarLanche(Lanche lanche) {
        try{
            if (buscarLanche(lanche.getNome()).getStatusCode().equals(HttpStatus.NOT_FOUND)) {
                lancheRepository.save(
                        new Lanche(
                                lanche.getNome(),
                                lanche.getDescricao(),
                                lanche.getPreco()
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

    public ResponseEntity<Lanche> buscarLanche(String nome) {
        Optional<Lanche> lancheData_ = lancheRepository.findByNome(nome);
        if (lancheData_.isPresent()) {
            return new ResponseEntity<>(lancheData_.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
