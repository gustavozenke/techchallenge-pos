package com.fiap.techchallenge.domain.cliente;

import org.springframework.http.ResponseEntity;

public interface ClienteUseCase {
    ResponseEntity<String> criarCliente(Cliente cliente);
    ResponseEntity<Cliente> buscarCliente(String cpf);
    ResponseEntity<String> apagarCliente(String cpf);
}
