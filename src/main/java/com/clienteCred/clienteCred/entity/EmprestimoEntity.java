package com.clienteCred.clienteCred.entity;

import java.time.LocalDate;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "cadastro_emprestimo")
public class EmprestimoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cpf_cliente")
    private ClienteEntity cliente;

    @NotNull
    private Double valorInicial;

    private Double valorFinal;

    @NotNull
    @Enumerated(EnumType.STRING)
    private EnumTipoRelacionamento relacionamento;

    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataInicial;

    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataFinal;

    public EmprestimoEntity() {}

    public EmprestimoEntity(ClienteEntity cliente, Double valorInicial, Double valorFinal, EnumTipoRelacionamento relacionamento, LocalDate dataInicial, LocalDate dataFinal) {
        this.cliente = cliente;
        this.valorInicial = valorInicial;
        this.valorFinal = valorFinal;
        this.relacionamento = relacionamento;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClienteEntity getCliente() {
        return cliente;
    }

    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }

    public Double getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(Double valorInicial) {
        this.valorInicial = valorInicial;
    }

    public Double getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(Double valorFinal) {
        this.valorFinal = valorFinal;
    }

    public EnumTipoRelacionamento getRelacionamento() {
        return relacionamento;
    }

    public void setRelacionamento(EnumTipoRelacionamento relacionamento) {
        this.relacionamento = relacionamento;
    }

    public LocalDate getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(LocalDate dataInicial) {
        this.dataInicial = dataInicial;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(LocalDate dataFinal) {
        this.dataFinal = dataFinal;
    }
}
