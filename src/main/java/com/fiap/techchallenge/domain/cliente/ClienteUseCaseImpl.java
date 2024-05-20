package com.fiap.techchallenge.domain.cliente;

import com.fiap.techchallenge.ports.out.adapters.ClienteRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Log4j2
@Service
public class ClienteUseCaseImpl implements ClienteUseCase {

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
                log.info("cliente {} cadastrado", cliente.getNome());
                return new ResponseEntity<>(null, HttpStatus.CREATED);
            } else {
                log.warn("cliente já cadastrado");
                return new ResponseEntity<>(null, HttpStatus.CONFLICT);
            }
        } catch (Exception e) {
            log.error(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Cliente> buscarCliente(String cpf) {
        Optional<Cliente> clienteData_ = clienteRepository.findByCpf(cpf);
        if (clienteData_.isPresent()) {
            return new ResponseEntity<>(clienteData_.get(), HttpStatus.OK);
        } else {
            log.warn("cpf {} não encontrado", cpf);
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<String> apagarCliente(String cpf) {
        try {
            Cliente clienteData_ = buscarCliente(cpf).getBody();
            clienteRepository.delete(clienteData_);
            log.info("cliente {} deletado", clienteData_.getId());
            return new ResponseEntity<>("cliente apagado", HttpStatus.OK);
        } catch (Exception e) {
            log.error(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
