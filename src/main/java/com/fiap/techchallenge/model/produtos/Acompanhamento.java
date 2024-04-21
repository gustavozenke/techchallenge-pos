package com.fiap.techchallenge.model.produtos;

import com.fiap.techchallenge.model.Produto;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Acompanhamento extends Produto {
    public Acompanhamento(String nome, String descricao, float preco) {
        super(nome, descricao, preco);
    }
}
