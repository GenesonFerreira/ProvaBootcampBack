package com.clienteCred.clienteCred.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clienteCred.clienteCred.DTOs.EmprestimoDTO;
import com.clienteCred.clienteCred.entity.EmprestimoEntity;
import com.clienteCred.clienteCred.service.EmprestimoService;

@RestController
@RequestMapping("/clientes")
public class EmprestimoController {

    @Autowired
    private EmprestimoService cadastroEmprestimoService;

    @PostMapping("/{cpf}/emprestimos")
    public ResponseEntity<EmprestimoEntity> adicionarEmprestimo(@PathVariable String cpf,
                                                                @RequestBody EmprestimoEntity novoEmprestimo) {
        EmprestimoEntity emprestimo = cadastroEmprestimoService.adicionarEmprestimo(cpf, novoEmprestimo);
        return ResponseEntity.status(HttpStatus.CREATED).body(emprestimo);
    }

    @DeleteMapping("/{cpf}/emprestimos/{id}")
    public ResponseEntity<Void> removerEmprestimo(@PathVariable String cpf, @PathVariable Long id) {
        cadastroEmprestimoService.removerEmprestimo(cpf, id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{cpf}/emprestimos/{id}")
    public ResponseEntity<EmprestimoDTO> buscarEmprestimo(@PathVariable String cpf, @PathVariable Long id) {
        EmprestimoDTO emprestimoDTO = cadastroEmprestimoService.buscarEmprestimo(cpf, id);
        return ResponseEntity.ok(emprestimoDTO);
    }

    @GetMapping("/{cpf}/emprestimos")
    public ResponseEntity<List<EmprestimoEntity>> buscarTodosEmprestimos(@PathVariable String cpf) {
        List<EmprestimoEntity> emprestimos = cadastroEmprestimoService.listarEmprestimos(cpf);
        return ResponseEntity.ok(emprestimos);
    }
}
