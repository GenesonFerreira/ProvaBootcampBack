package com.clienteCred.clienteCred.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;

@Entity
@Table(name = "clientes")
public class ClienteEntity {
	
	@Id
	@Column(name = "cpf", nullable = false, unique = true)
	private String cpf;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "telefone", nullable = false)
    private String telefone;

    @Column(name = "rua", nullable = false)
    private String rua;

    @Column(name = "numero", nullable = false)
    private int numero;

    @Column(name = "cep", nullable = false)
    private String cep;

    @Column(name = "rendimento_mensal", nullable = false)
    private double rendimentoMensal;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<EmprestimoEntity> emprestimos;

    public ClienteEntity() {
    }

    public ClienteEntity(String cpf, String nome, String telefone, String rua, int numero, String cep, double rendimentoMensal) {
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.rua = rua;
        this.numero = numero;
        this.cep = cep;
        this.rendimentoMensal = rendimentoMensal;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public double getRendimentoMensal() {
        return rendimentoMensal;
    }

    public void setRendimentoMensal(double rendimentoMensal) {
        this.rendimentoMensal = rendimentoMensal;
    }
    
    @JsonIgnoreProperties("cliente")
    public List<EmprestimoEntity> getEmprestimos() {
        return emprestimos;
    }

    public void setEmprestimos(List<EmprestimoEntity> emprestimos) {
        this.emprestimos = emprestimos;
    }

}
