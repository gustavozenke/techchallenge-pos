package com.fiap.techchallenge.domain.service;

import com.fiap.techchallenge.adapters.repository.produtos.BebidaRepository;
import com.fiap.techchallenge.domain.model.produtos.Bebida;
import com.fiap.techchallenge.ports.in.produtos.bebida.BebidaUseCase;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Log4j2
@Service
public class BebidaUseCaseImpl implements BebidaUseCase {

    @Autowired
    BebidaRepository bebidaRepository;

    public ResponseEntity<String> criarBebida(Bebida bebida) {
        try {
            if(buscarBebida(gerarNomeBanco(bebida.getNome())).getStatusCode().equals(HttpStatus.NOT_FOUND)) {
                bebidaRepository.save(
                        new Bebida(
                                bebida.getNome(),
                                gerarNomeBanco(bebida.getNome()),
                                bebida.getDescricao(),
                                bebida.getPreco(),
                                bebida.getTamanho()
                        )
                );
                log.info("{} criado", bebida.getNome());
                return new ResponseEntity<>(null, HttpStatus.CREATED);
            } else {
                log.warn("{} já existe no banco de dados", bebida.getNome());
                return new ResponseEntity<>(null, HttpStatus.CONFLICT);
            }
        } catch (Exception e) {
            log.error(e);
            return new ResponseEntity<>(e.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private String gerarNomeBanco(String nome) {
        String nomeBanco = nome.replaceAll(" ","_").toLowerCase();
        return nomeBanco;
    }

    public ResponseEntity<Bebida> buscarBebida(String nomeBanco) {
        Optional<Bebida> bebidaData_ = bebidaRepository.findByNomeBanco(nomeBanco);
        if (bebidaData_.isPresent()) {
            return new ResponseEntity<>(bebidaData_.get(), HttpStatus.OK);
        } else {
            log.warn("{} não encontrado no banco de dados", nomeBanco);
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Bebida> buscarBebidaNomeETamanho(String nomeBanco, String tamanho) {
        Optional<Bebida> bebidaData_ = bebidaRepository.findByNomeBancoAndTamanho(nomeBanco,tamanho);
        if (bebidaData_.isPresent()) {
            return new ResponseEntity<>(bebidaData_.get(), HttpStatus.OK);
        } else {
            log.warn("{} {} não encontrado no banco de dados", nomeBanco, tamanho);
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<List<Bebida>> listarBebidas() {
        List<Bebida> bebidas = bebidaRepository.findAll();
        return new ResponseEntity<>(bebidas, HttpStatus.OK);
    }
    
    public ResponseEntity<Bebida> atualizarBebida(String nomeBanco, Bebida bebida) {
        try {
            Bebida bebidaData_ = buscarBebida(nomeBanco).getBody();
            bebidaData_.setDescricao(bebida.getDescricao());
            bebidaData_.setTamanho(bebida.getTamanho());
            bebidaData_.setPreco(bebida.getPreco());
            bebidaRepository.save(bebidaData_);
            log.info("{} atualizado com sucesso", bebidaData_.getNome());
            return new ResponseEntity<>(bebidaData_, HttpStatus.OK);
        } catch (Exception e) {
            log.error(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<String> apagarBebida(String nomeBanco) {
        try {
            Bebida bebidaData_ = buscarBebida(nomeBanco).getBody();
            bebidaRepository.delete(bebidaData_);
            log.info("{} excluido", bebidaData_.getNome());
            return new ResponseEntity<>(bebidaData_.getNome() + " apagado", HttpStatus.OK);
        } catch (Exception e) {
            log.error(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
