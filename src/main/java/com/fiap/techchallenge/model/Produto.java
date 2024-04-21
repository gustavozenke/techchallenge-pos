package com.fiap.techchallenge.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Produto {
    private Long id;
    private String nome;
    private String descricao;
    private float preco;

}
