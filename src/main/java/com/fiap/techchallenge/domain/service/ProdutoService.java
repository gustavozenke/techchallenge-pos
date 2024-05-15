package com.fiap.techchallenge.domain.service;

import com.fiap.techchallenge.domain.dto.ProdutoDTO;
import com.fiap.techchallenge.domain.enums.TiposProdutos;
import com.fiap.techchallenge.domain.model.produtos.Acompanhamento;
import com.fiap.techchallenge.usecase.repository.produtos.AcompanhamentoRepository;
import com.fiap.techchallenge.usecase.repository.produtos.BebidaRepository;
import com.fiap.techchallenge.usecase.repository.produtos.LancheRepository;
import com.fiap.techchallenge.usecase.repository.produtos.SobremesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import static com.fiap.techchallenge.domain.enums.TiposProdutos.ACOMPANHAMENTO;

@Service
public class ProdutoService {

    @Autowired
    AcompanhamentoRepository acompanhamentoRepository;

    @Autowired
    BebidaRepository bebidaRepository;

    @Autowired
    LancheRepository lancheRepository;

    @Autowired
    SobremesaRepository sobremesaRepository;

    public ResponseEntity<String> criarProduto(ProdutoDTO dto) {
        try {
            if (buscarAcompanhamento(gerarNomeBanco(acompanhamento.getNome())).getStatusCode().equals(HttpStatus.NOT_FOUND)) {
                acompanhamentoRepository.save(
                        new Acompanhamento(
                                acompanhamento.getNome(),
                                gerarNomeBanco(acompanhamento.getNome()),
                                acompanhamento.getDescricao(),
                                acompanhamento.getPreco()
                        )
                );
                return new ResponseEntity<>(null, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(null, HttpStatus.CONFLICT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
