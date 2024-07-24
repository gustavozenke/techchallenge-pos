package com.fiap.techchallenge.domain.model.produtos;

import com.fiap.techchallenge.domain.model.Produto;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@Document
public class Bebida extends Produto {
    private List<String> tamanhos;

    public Bebida(String nome, String nomeBanco, String descricao, float preco, List<String> tamanhos) {
        super(nome, nomeBanco, descricao, preco);
        this.tamanhos = tamanhos;
    }
}
