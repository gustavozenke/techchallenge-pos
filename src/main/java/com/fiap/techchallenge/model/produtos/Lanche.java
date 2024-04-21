package com.fiap.techchallenge.model.produtos;

import com.fiap.techchallenge.model.Produto;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document
public class Lanche extends Produto {

    public Lanche(String nome, String descricao, float preco) {
        super(nome, descricao, preco);
    }

}
