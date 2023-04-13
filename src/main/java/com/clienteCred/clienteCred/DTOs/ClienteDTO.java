package com.clienteCred.clienteCred.DTOs;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

public class ClienteDTO {

    @CPF // Validação do CPF usando a anotação CPF do Hibernate Validator
    private String cpf;

    @NotNull // Indica que o atributo não pode ser nulo
    private String nome;

    @NotNull // Indica que o atributo não pode ser nulo
    private String telefone;

    @NotNull // Indica que o atributo não pode ser nulo
    private String rua;

    @NotNull // Indica que o atributo não pode ser nulo
    private Integer numero;

    @NotNull // Indica que o atributo não pode ser nulo
    private String cep;

    @NotNull // Indica que o atributo não pode ser nulo
    private Double rendimentoMensal;

    public ClienteDTO() {
    }

    public ClienteDTO(String cpf, String nome, String telefone, String rua, Integer numero, String cep,
            Double rendimentoMensal) {
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

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Double getRendimentoMensal() {
        return rendimentoMensal;
    }

    public void setRendimentoMensal(Double rendimentoMensal) {
        this.rendimentoMensal = rendimentoMensal;
    }

}
