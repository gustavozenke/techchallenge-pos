package com.fiap.techchallenge.ports.in;

import com.fiap.techchallenge.domain.cliente.Cliente;
import com.fiap.techchallenge.domain.cliente.ClienteUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    ClienteUseCase clienteUseCase;

    @PostMapping("/new")
    public ResponseEntity<String> criarCliente(@RequestBody Cliente cliente){
        try {
            return clienteUseCase.criarCliente(cliente);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<Cliente> buscarCliente(@PathVariable("cpf") String cpf){
        try {
            return clienteUseCase.buscarCliente(cpf);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //TODO fazer updates

    @DeleteMapping("/{cpf}")
    public ResponseEntity<String> apagarCliente(@PathVariable("cpf") String cpf){
        try {
            return clienteUseCase.apagarCliente(cpf);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
