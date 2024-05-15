package com.fiap.techchallenge.ports.in.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class ProdutoDTO {

    private String nome;
    private String tipo;

    @JsonProperty("nome_banco")
    private String nomeBanco;

    private String descricao;
    private float preco;

}
