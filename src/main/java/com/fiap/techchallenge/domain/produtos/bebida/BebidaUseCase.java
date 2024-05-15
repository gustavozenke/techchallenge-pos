package com.fiap.techchallenge.domain.produtos.bebida;

import com.fiap.techchallenge.ports.out.adapters.produtos.BebidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BebidaUseCase {

    @Autowired
    BebidaRepository bebidaRepository;

    public ResponseEntity<String> criarBebida(Bebida bebida) {
        try {
            if(buscarBebida(bebida.getNome()).getStatusCode().equals(HttpStatus.NOT_FOUND)) {
                bebidaRepository.save(
                        new Bebida(
                                bebida.getNome(),
                                gerarNomeBanco(bebida.getNomeBanco()),
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

    public String gerarNomeBanco(String nome){
        String nomeBanco = nome.replaceAll(" ","_").toLowerCase();
        return nomeBanco;
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
