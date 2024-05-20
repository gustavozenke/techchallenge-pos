package com.fiap.techchallenge.domain.produtos.sobremesa;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SobremesaUseCase {
    ResponseEntity<String> criarSobremsa(Sobremesa sobremesa);
    String gerarNomeBanco(String nome);
    ResponseEntity<Sobremesa> buscarSobremesa(String nome);
    ResponseEntity<List<Sobremesa>> listarSobremesas();
    ResponseEntity<String> apagarSobremesa(String nomeBanco);
}
