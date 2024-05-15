package com.fiap.techchallenge.domain.produtos.lanche;

import com.fiap.techchallenge.ports.out.adapters.produtos.LancheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LancheUseCase {

    @Autowired
    LancheRepository lancheRepository;

    public ResponseEntity<String> criarLanche(Lanche lanche) {
        try{
            if (buscarLanche(lanche.getNome()).getStatusCode().equals(HttpStatus.NOT_FOUND)) {
                lancheRepository.save(
                        new Lanche(
                                lanche.getNome(),
                                gerarNomeBanco(lanche.getNomeBanco()),
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

    public String gerarNomeBanco(String nome){
        String nomeBanco = nome.replaceAll(" ","_").toLowerCase();
        return nomeBanco;
    }

    public ResponseEntity<Lanche> buscarLanche(String nomeBanco) {
        Optional<Lanche> lancheData_ = lancheRepository.findByNomeBanco(nomeBanco);
        if (lancheData_.isPresent()) {
            return new ResponseEntity<>(lancheData_.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
