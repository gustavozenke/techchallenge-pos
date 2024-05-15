package com.fiap.techchallenge.usecase.controller;

import com.fiap.techchallenge.domain.dto.ProdutoDTO;
import com.fiap.techchallenge.domain.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @PostMapping("/new")
    public ResponseEntity<String> criarAcompanhamento(@RequestBody ProdutoDTO dto){
        try {
            return produtoService.criarProduto(dto);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @GetMapping("/all")
//    public ResponseEntity<List<Acompanhamento>> listarAcompanhamentos(){
//        try {
//            return produtoService.listarProdutos();
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @GetMapping("/{nomeBanco}")
//    public ResponseEntity<Acompanhamento> buscarAcompanhamento(@PathVariable("nomeBanco") String nomeBanco){
//        try {
//            return produtoService.buscarProduto(nomeBanco);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @DeleteMapping("/{nomeBanco}")
//    public ResponseEntity apagarAcompanhamento(@PathVariable("nomeBanco") String nomeBanco){
//        try {
//            return produtoService.apagarProduto(nomeBanco);
//        } catch (Exception e) {
//            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
}
