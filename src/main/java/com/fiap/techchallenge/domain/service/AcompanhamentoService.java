package com.fiap.techchallenge.domain.service;

import com.fiap.techchallenge.domain.model.produtos.Acompanhamento;
import com.fiap.techchallenge.usecase.repository.produtos.AcompanhamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AcompanhamentoService {

    @Autowired
    AcompanhamentoRepository acompanhamentoRepository;

    public ResponseEntity<String> criarAcompanhamento(Acompanhamento acompanhamento){
        try {
            if (buscarAcompanhamento(gerarNomeBanco(acompanhamento.getNome())).getStatusCode().equals(HttpStatus.NOT_FOUND)) {
                acompanhamentoRepository.save(
                        new Acompanhamento(
                                acompanhamento.getNome(),
                                gerarNomeBanco(acompanhamento.getNome()),
                                acompanhamento.getDescricao(),
                                acompanhamento.getPreco()
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

    public ResponseEntity<Acompanhamento> buscarAcompanhamento(String nomeBanco) {
        Optional<Acompanhamento> acompanhamentoData_ = acompanhamentoRepository.findByNomeBanco(nomeBanco);
        if (acompanhamentoData_.isPresent()) {
            return new ResponseEntity<>(acompanhamentoData_.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<List<Acompanhamento>> listarAcompanhamentos() {
       List<Acompanhamento> acompanhamentos = acompanhamentoRepository.findAll();
        return new ResponseEntity<>(acompanhamentos, HttpStatus.OK);
    }

}
