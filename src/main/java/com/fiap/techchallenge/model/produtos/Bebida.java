package com.fiap.techchallenge.model.produtos;

import com.fiap.techchallenge.model.Produto;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document
public class Bebida extends Produto {
    private String tamanho;

    public Bebida(String nome, String descricao, float preco) {
        super(nome, descricao, preco);
    }

    public Bebida(String nome, String descricao, float preco, String tamanho) {
        super(nome, descricao, preco);
        this.tamanho = tamanho;
    }
}
