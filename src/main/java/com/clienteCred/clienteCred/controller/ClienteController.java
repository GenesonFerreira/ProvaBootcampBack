package com.clienteCred.clienteCred.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clienteCred.clienteCred.entity.ClienteEntity;
import com.clienteCred.clienteCred.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public List<ClienteEntity> buscarTodosClientes() {
        return clienteService.buscarTodosClientes();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/{cpf}")
    public ResponseEntity<ClienteEntity> buscarClientePorCPF(@PathVariable String cpf) {
        ClienteEntity cliente = clienteService.buscarClientePorCPF(cpf);
        return ResponseEntity.ok(cliente);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
    public ResponseEntity<Object> adicionarCliente(@RequestBody @Valid ClienteEntity cliente) {
        if (clienteService.existeClientePorCpf(cliente.getCpf())) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(Collections.singletonMap("mensagem", "CPF ja cadastrado no banco de dados"));
        }
        clienteService.adicionarCliente(cliente);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Collections.singletonMap("mensagem", "Cliente salvo com sucesso no banco de dados."));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/{cpf}")
    public ResponseEntity<Map<String, String>> deletarClientePorCPF(@PathVariable String cpf) {
        clienteService.deletarClientePorCPF(cpf);
        Map<String, String> response = Collections.singletonMap("message", "Cliente removido com sucesso do banco de dados.");
        return ResponseEntity.ok().body(response);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/{cpf}")
    public ResponseEntity<Map<String, String>> atualizarClientePorCPF(@PathVariable String cpf, @RequestBody @Valid ClienteEntity clienteAtualizado) {
        clienteService.atualizarClientePorCPF(cpf, clienteAtualizado);
        return ResponseEntity.ok(Collections.singletonMap("message","Cliente atualizado com sucesso no banco de dados."));
    }
}
