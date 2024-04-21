package com.fiap.techchallenge.model.produtos;

import com.fiap.techchallenge.model.Produto;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Bebida extends Produto {

    public Bebida(String nome, String descricao, float preco) {
        super(nome, descricao, preco);
    }
}
