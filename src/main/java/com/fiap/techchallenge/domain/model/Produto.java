package com.fiap.techchallenge.domain.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Produto {

    @Id
    private String id;
    private String nome;
    private String descricao;
    private float preco;

    public Produto(String nome, String descricao, float preco) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }
}
