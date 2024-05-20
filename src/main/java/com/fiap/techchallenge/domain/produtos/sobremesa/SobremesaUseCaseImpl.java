package com.fiap.techchallenge.domain.produtos.sobremesa;

import com.fiap.techchallenge.ports.out.adapters.produtos.SobremesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SobremesaUseCaseImpl implements SobremesaUseCase {

    @Autowired
    SobremesaRepository sobremesaRepository;

    public ResponseEntity<String> criarSobremsa(Sobremesa sobremesa) {
        try {
            if (buscarSobremesa(sobremesa.getNome()).getStatusCode().equals(HttpStatus.NOT_FOUND)) {
                sobremesaRepository.save(
                        new Sobremesa(
                                sobremesa.getNome(),
                                gerarNomeBanco(sobremesa.getNome()),
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

    public String gerarNomeBanco(String nome) {
        String nomeBanco = nome.replaceAll(" ","_").toLowerCase();
        return nomeBanco;
    }

    public ResponseEntity<Sobremesa> buscarSobremesa(String nome) {
        Optional<Sobremesa> sobremesaData_ = sobremesaRepository.findByNome(nome);
        if (sobremesaData_.isPresent()) {
            return new ResponseEntity<>(sobremesaData_.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<List<Sobremesa>> listarSobremesas() {
        List<Sobremesa> sobremesas = sobremesaRepository.findAll();
        return new ResponseEntity<>(sobremesas, HttpStatus.OK);
    }

    public ResponseEntity<String> apagarSobremesa(String nomeBanco) {
        try {
            Sobremesa sobremesaData_ = buscarSobremesa(nomeBanco).getBody();
            sobremesaRepository.delete(sobremesaData_);
            return new ResponseEntity<>(sobremesaData_.getNome() + " apagado", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
