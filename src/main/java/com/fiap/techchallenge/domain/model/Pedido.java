package com.fiap.techchallenge.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fiap.techchallenge.domain.model.produtos.Acompanhamento;
import com.fiap.techchallenge.domain.model.produtos.Bebida;
import com.fiap.techchallenge.domain.model.produtos.Lanche;
import com.fiap.techchallenge.domain.model.produtos.Sobremesa;
import com.fiap.techchallenge.domain.statemachine.EstadoPedido;
import jakarta.annotation.Nullable;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Document
public class Pedido {

    @JsonIgnore
    @Id
    private String id;

    @JsonProperty("estado_pedido")
    private EstadoPedido estadoPedido;

    //numero do pedido
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

    @JsonProperty(value = "data_pedido", access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime dataPedido;

    public Pedido(long sequencia, @Nullable Cliente cliente, @Nullable List<Lanche> lanches, @Nullable List<Bebida> bebidas, @Nullable List<Sobremesa> sobremesas, @Nullable List<Acompanhamento> acompanhamentos) {
        this.estadoPedido = EstadoPedido.A_PAGAR;
        this.sequencia = sequencia;
        this.cliente = cliente;
        this.lanches = lanches;
        this.bebidas = bebidas;
        this.sobremesas = sobremesas;
        this.acompanhamentos = acompanhamentos;
        this.dataPedido = LocalDateTime.now();
    }
}
