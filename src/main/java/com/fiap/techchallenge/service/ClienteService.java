package com.fiap.techchallenge.service;

import com.fiap.techchallenge.model.Cliente;
import com.fiap.techchallenge.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
     private ClienteRepository clienteRepository;


    public ResponseEntity<Cliente> criarCliente(Cliente cliente) {
        try {
            if (procurarCliente(cliente.getCpf()).getStatusCode().equals(HttpStatus.NOT_FOUND)) {
                clienteRepository.save(
                        new Cliente(
                                cliente.getCpf(),
                                cliente.getNome(),
                                cliente.getEmail()
                        )
                );
                return new ResponseEntity<>(null, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(null, HttpStatus.CONFLICT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Cliente> procurarCliente(String cpf) {
        Optional<Cliente> clienteData_ = clienteRepository.findByCpf(cpf);
        if (clienteData_.isPresent()) {
            return new ResponseEntity<>(clienteData_.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Cliente> apagarCliente(String cpf) {
        try {
            Cliente clienteData_ = procurarCliente(cpf).getBody();
            clienteRepository.delete(clienteData_);
            return new ResponseEntity<>(null, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
