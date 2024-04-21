package com.fiap.techchallenge.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Cliente {
    @Id
    private String id;
    private String cpf;
    private String nome;
    private String email;
    private boolean marketing;

    public Cliente(String cpf, String nome, String email, boolean marketing) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.marketing = marketing;
    }
}
