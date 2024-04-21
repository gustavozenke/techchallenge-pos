package com.fiap.techchallenge.model;

import com.fiap.techchallenge.model.produtos.Acompanhamento;
import com.fiap.techchallenge.model.produtos.Bebida;
import com.fiap.techchallenge.model.produtos.Lanche;
import com.fiap.techchallenge.model.produtos.Sobremesa;
import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Pedido {

    private long id;
    private String estadoPedido;
    private String estadoPagamento;

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
}
