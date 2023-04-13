package com.clienteCred.clienteCred.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clienteCred.clienteCred.DTOs.EmprestimoDTO;
import com.clienteCred.clienteCred.entity.EmprestimoEntity;
import com.clienteCred.clienteCred.entity.ClienteEntity;
import com.clienteCred.clienteCred.repository.EmprestimoRepository;
import com.clienteCred.clienteCred.repository.ClienteRepository;

import java.util.List;

@Service
public class EmprestimoService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private EmprestimoRepository cadastroEmprestimoRepository;

	public EmprestimoEntity adicionarEmprestimo(String cpf, EmprestimoEntity novoEmprestimo) {
		ClienteEntity cliente = clienteRepository.findById(cpf)
				.orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

		if (novoEmprestimo.getValorInicial() > cliente.getRendimentoMensal() * 10) {
			throw new RuntimeException("Limite de empréstimo excedido");
		}

		double valorTotalEmprestimos = cliente.getEmprestimos().stream().mapToDouble(emp -> emp.getValorInicial())
				.sum();

		if (valorTotalEmprestimos + novoEmprestimo.getValorInicial() > cliente.getRendimentoMensal() * 10) {
			throw new RuntimeException("Limite de empréstimo excedido");
		}

		double valorFinal;

		switch (novoEmprestimo.getRelacionamento()) {
		case BRONZE:
			valorFinal = novoEmprestimo.getValorInicial() * 1.80;
			break;
		case PRATA:
			if (novoEmprestimo.getValorInicial() > 5000) {
				valorFinal = novoEmprestimo.getValorInicial() * 1.40;
			} else {
				valorFinal = novoEmprestimo.getValorInicial() * 1.60;
			}
			break;
		case OURO:
			if (cliente.getEmprestimos().size() == 0) {
				valorFinal = novoEmprestimo.getValorInicial() * 1.2;
			} else {
				valorFinal = novoEmprestimo.getValorInicial() * 1.3;
			}
			break;
		default:
			valorFinal = novoEmprestimo.getValorInicial();
			break;
		}

		novoEmprestimo.setValorFinal(valorFinal);
		novoEmprestimo.setCliente(cliente);
		return cadastroEmprestimoRepository.save(novoEmprestimo);
	}

	public void removerEmprestimo(String cpf, Long idEmprestimo) {
		ClienteEntity cliente = clienteRepository.findById(cpf)
				.orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

		EmprestimoEntity emprestimo = cliente.getEmprestimos().stream()
				.filter(emp -> emp.getId().equals(idEmprestimo)).findFirst()
				.orElseThrow(() -> new RuntimeException("Empréstimo não encontrado"));

		cliente.getEmprestimos().remove(emprestimo);
		cadastroEmprestimoRepository.delete(emprestimo);
	}

	public EmprestimoDTO buscarEmprestimo(String cpf, Long idEmprestimo) {
		ClienteEntity cliente = clienteRepository.findById(cpf)
				.orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

		EmprestimoEntity emprestimo = cliente.getEmprestimos().stream()
				.filter(emp -> emp.getId().equals(idEmprestimo)).findFirst()
				.orElseThrow(() -> new RuntimeException("Empréstimo não encontrado"));

		return new EmprestimoDTO(emprestimo.getId(), emprestimo.getValorInicial(), emprestimo.getValorFinal(),
				emprestimo.getRelacionamento(), emprestimo.getDataInicial(), emprestimo.getDataFinal());
	}

	public List<EmprestimoEntity> listarEmprestimos(String cpf) {
		ClienteEntity cliente = clienteRepository.findById(cpf)
				.orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

		return cliente.getEmprestimos();
	}
}
