package com.fiap.techchallenge.domain.produtos.sobremesa;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SobremesaUseCase {
    ResponseEntity<String> criarSobremsa(Sobremesa sobremesa);
    ResponseEntity<Sobremesa> buscarSobremesa(String nomeBanco);
    ResponseEntity<List<Sobremesa>> listarSobremesas();
    ResponseEntity<String> apagarSobremesa(String nomeBanco);
    ResponseEntity<Sobremesa> atualizarSobremesa(String nomeBanco, Sobremesa sobremesa);
}
