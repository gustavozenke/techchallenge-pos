package com.fiap.techchallenge.controller;

import com.fiap.techchallenge.model.Cliente;
import com.fiap.techchallenge.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired ClienteService clienteService;

    @PostMapping("/new")
    public ResponseEntity<Cliente> criarCliente(@RequestBody Cliente cliente){
        try{
            return clienteService.criarCliente(cliente);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<Cliente> criarCliente(@PathVariable("cpf") String cpf){
        try{
            return clienteService.procurarCliente(cpf);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //TODO fazer updates

    @DeleteMapping("/{cpf}")
    public ResponseEntity<Cliente> apagarCliente(@PathVariable("cpf") String cpf){
        try{
            return clienteService.apagarCliente(cpf);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
