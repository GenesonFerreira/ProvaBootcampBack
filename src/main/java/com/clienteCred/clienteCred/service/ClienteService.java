package com.clienteCred.clienteCred.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clienteCred.clienteCred.entity.ClienteEntity;
import com.clienteCred.clienteCred.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<ClienteEntity> buscarTodosClientes() {
        return clienteRepository.findAll();
    }

    public ClienteEntity buscarClientePorCPF(String cpf) {
        Optional<ClienteEntity> cliente = clienteRepository.findById(cpf);
        if(cliente.isPresent()){
            return cliente.get();
        } else {
            throw new NoSuchElementException("Cliente com CPF " + cpf + " não encontrado na base de dados.");
        }
    }

    public ClienteEntity adicionarCliente(ClienteEntity cliente) {
        return clienteRepository.save(cliente);
    }
    
    public boolean existeClientePorCpf(String cpf) {
        return clienteRepository.findById(cpf).isPresent();
    }

    public void deletarClientePorCPF(String cpf) {
        clienteRepository.deleteById(cpf);
    }

    public ClienteEntity atualizarClientePorCPF(String cpf, ClienteEntity clienteAtualizado) {
        ClienteEntity clienteExistente = buscarClientePorCPF(cpf);
        if (clienteExistente != null) {
            clienteExistente.setNome(clienteAtualizado.getNome());
            clienteExistente.setTelefone(clienteAtualizado.getTelefone());
            clienteExistente.setRua(clienteAtualizado.getRua());
            clienteExistente.setNumero(clienteAtualizado.getNumero());
            clienteExistente.setCep(clienteAtualizado.getCep());
            clienteExistente.setRendimentoMensal(clienteAtualizado.getRendimentoMensal());
            return clienteRepository.save(clienteExistente);
        }
        return null;
    }
}

