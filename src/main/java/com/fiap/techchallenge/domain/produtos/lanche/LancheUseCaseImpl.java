package com.fiap.techchallenge.domain.produtos.lanche;

import com.fiap.techchallenge.ports.out.adapters.produtos.LancheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LancheUseCaseImpl implements LancheUseCase {

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
                return new ResponseEntity<>(lanche.getNome() + " salvo no banco de dados", HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(null, HttpStatus.CONFLICT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public String gerarNomeBanco(String nome) {
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

    public ResponseEntity<List<Lanche>> listarLanches() {
        List<Lanche> lanches = lancheRepository.findAll();
        return new ResponseEntity<>(lanches, HttpStatus.OK);
    }

    public ResponseEntity<String> apagarLanche(String nomeBanco) {
        try {
            Lanche lancheData_ = buscarLanche(nomeBanco).getBody();
            lancheRepository.delete(lancheData_);
            return new ResponseEntity<>(lancheData_.getNome() + " apagado", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
