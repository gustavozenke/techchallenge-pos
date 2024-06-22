package com.fiap.techchallenge.ports.in;

import com.fiap.techchallenge.domain.model.Cliente;
import org.springframework.http.ResponseEntity;

public interface ClienteUseCase {
    ResponseEntity<String> criarCliente(Cliente cliente);

    ResponseEntity<Cliente> buscarCliente(String cpf);

    ResponseEntity<String> apagarCliente(String cpf);

    ResponseEntity<Cliente> atualizarMarketing(String cpf, boolean marketing);

    ResponseEntity<Cliente> atualizarEmail(String cpf, String email);

    ResponseEntity<Cliente> atualizarNome(String cpf, String nome);
}
