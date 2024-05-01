package com.fiap.techchallenge.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fiap.techchallenge.domain.model.produtos.Acompanhamento;
import com.fiap.techchallenge.domain.model.produtos.Bebida;
import com.fiap.techchallenge.domain.model.produtos.Lanche;
import com.fiap.techchallenge.domain.model.produtos.Sobremesa;
import jakarta.annotation.Nullable;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class Pedido {

    @Id
    private String id;
    private String estadoPedido;
    private String estadoPagamento;
    @JsonIgnore
    private long sequencia;

    @Nullable
    private Cliente cliente;

    @Nullable
    private List<Lanche> lanches;
    @Nullable
    private List<Bebida> bebidas;
    @Nullable
    private List<Sobremesa> sobremesas;
    @Nullable
    private List<Acompanhamento> acompanhamentos;

    public Pedido(String estadoPedido, String estadoPagamento, long sequencia, @Nullable Cliente cliente, @Nullable List<Lanche> lanches, @Nullable List<Bebida> bebidas, @Nullable List<Sobremesa> sobremesas, @Nullable List<Acompanhamento> acompanhamentos) {
        this.estadoPedido = estadoPedido;
        this.estadoPagamento = estadoPagamento;
        this.sequencia = sequencia;
        this.cliente = cliente;
        this.lanches = lanches;
        this.bebidas = bebidas;
        this.sobremesas = sobremesas;
        this.acompanhamentos = acompanhamentos;
    }
}
