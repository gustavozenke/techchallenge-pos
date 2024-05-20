package com.fiap.techchallenge.domain.produtos.lanche;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface LancheUseCase {
    ResponseEntity<String> criarLanche(Lanche lanche);
    String gerarNomeBanco(String nome);
    ResponseEntity<Lanche> buscarLanche(String nomeBanco);
    ResponseEntity<List<Lanche>> listarLanches();
    ResponseEntity<String> apagarLanche(String nomeBanco);

}
