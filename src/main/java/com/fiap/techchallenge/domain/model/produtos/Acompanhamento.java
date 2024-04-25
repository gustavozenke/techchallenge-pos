package com.fiap.techchallenge.domain.model.produtos;

import com.fiap.techchallenge.domain.model.Produto;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document
public class Acompanhamento extends Produto {
    public Acompanhamento(String nome, String descricao, float preco) {
        super(nome, descricao, preco);
    }
}
