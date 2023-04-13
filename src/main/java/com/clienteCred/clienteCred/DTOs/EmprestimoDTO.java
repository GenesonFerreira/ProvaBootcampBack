package com.clienteCred.clienteCred.DTOs;

import java.time.LocalDate;

import com.clienteCred.clienteCred.entity.EnumTipoRelacionamento;

public class EmprestimoDTO {
    private Long id;
    private Double valorInicial;
    private Double valorFinal;
    private EnumTipoRelacionamento relacionamento;
    private LocalDate dataInicial;
    private LocalDate dataFinal;

    public EmprestimoDTO(Long id, Double valorInicial, Double valorFinal, EnumTipoRelacionamento relacionamento, LocalDate dataInicial, LocalDate dataFinal) {
        this.id = id;
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
