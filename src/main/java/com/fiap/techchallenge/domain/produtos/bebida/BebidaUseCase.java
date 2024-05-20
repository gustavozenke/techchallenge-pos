package com.fiap.techchallenge.domain.produtos.bebida;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BebidaUseCase {
    ResponseEntity<String> criarBebida(Bebida bebida);
    String gerarNomeBanco(String nome);
    ResponseEntity<Bebida> buscarBebida(String nome);
    ResponseEntity<List<Bebida>> listarBebidas();
    ResponseEntity<String> apagarBebida(String nomeBanco);
}
