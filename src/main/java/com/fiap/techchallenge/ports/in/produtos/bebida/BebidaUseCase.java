package com.fiap.techchallenge.ports.in.produtos.bebida;

import com.fiap.techchallenge.domain.model.produtos.Bebida;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BebidaUseCase {
    ResponseEntity<String> criarBebida(Bebida bebida);
    ResponseEntity<Bebida> buscarBebida(String nomeBanco);
    ResponseEntity<Bebida> buscarBebidaNomeETamanho(String nomeBanco, String tamanho);
    ResponseEntity<List<Bebida>> listarBebidas();
    ResponseEntity<String> apagarBebida(String nomeBanco);
    ResponseEntity<Bebida> atualizarBebida(String nomeBanco, Bebida bebida);
}
