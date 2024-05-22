package com.fiap.techchallenge.domain.produtos.bebida;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BebidaUseCase {
    ResponseEntity<String> criarBebida(Bebida bebida);
    ResponseEntity<Bebida> buscarBebida(String nomeBanco);
    ResponseEntity<List<Bebida>> listarBebidas();
    ResponseEntity<String> apagarBebida(String nomeBanco);
    ResponseEntity<Bebida> atualizarBebida(String nomeBanco, Bebida bebida);
}
