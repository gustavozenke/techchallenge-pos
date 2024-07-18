package com.fiap.techchallenge.ports.in.produtos;

import com.fiap.techchallenge.domain.model.produtos.Lanche;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface LancheUseCase {
    ResponseEntity<String> criarLanche(Lanche lanche);

    ResponseEntity<Lanche> buscarLanche(String nomeBanco);

    ResponseEntity<List<Lanche>> listarLanches();

    ResponseEntity<String> apagarLanche(String nomeBanco);

    ResponseEntity<Lanche> atualizarLanche(String nomeBanco, Lanche lanche);
}
