package com.fiap.techchallenge.domain.produtos.acompanhamento;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AcompanhamentoUseCase {
    ResponseEntity<String> criarAcompanhamento(Acompanhamento acompanhamento);
    String gerarNomeBanco(String nome);
    ResponseEntity<Acompanhamento> buscarAcompanhamento(String nomeBanco);
    ResponseEntity<List<Acompanhamento>> listarAcompanhamentos();
    ResponseEntity<String> apagarAcompanhamento(String nomeBanco);
}
