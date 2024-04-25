package com.fiap.techchallenge.domain.service;

import com.fiap.techchallenge.domain.model.Cliente;
import com.fiap.techchallenge.usecase.repository.produtos.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
     private ClienteRepository clienteRepository;


    public ResponseEntity<String> criarCliente(Cliente cliente) {
        try {
            if (buscarCliente(cliente.getCpf()).getStatusCode().equals(HttpStatus.NOT_FOUND)) {
                clienteRepository.save(
                        new Cliente(
                                cliente.getCpf(),
                                cliente.getNome(),
                                cliente.getEmail(),
                                cliente.isMarketing()
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

    public ResponseEntity<Cliente> buscarCliente(String cpf) {
        Optional<Cliente> clienteData_ = clienteRepository.findByCpf(cpf);
        if (clienteData_.isPresent()) {
            return new ResponseEntity<>(clienteData_.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Cliente> apagarCliente(String cpf) {
        try {
            Cliente clienteData_ = buscarCliente(cpf).getBody();
            clienteRepository.delete(clienteData_);
            return new ResponseEntity<>(null, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
