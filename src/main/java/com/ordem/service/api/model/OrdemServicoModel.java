package com.ordem.service.api.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.ordem.service.domain.model.StatusOrdemServico;

public class OrdemServicoModel {
	
	// Representação do Model para Visualização da Ordem de Serviço.
	private Long id;
	//private String nomeCliente;
	private ClienteResumoModel cliente;
	private String descricao;
	private BigDecimal precos;
	private StatusOrdemServico status;
	private OffsetDateTime dataAbertura;
	private OffsetDateTime dataFinalizacao;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	/*public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}*/
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public BigDecimal getPrecos() {
		return precos;
	}
	public void setPrecos(BigDecimal precos) {
		this.precos = precos;
	}
	public StatusOrdemServico getStatus() {
		return status;
	}
	public void setStatus(StatusOrdemServico status) {
		this.status = status;
	}
	public OffsetDateTime getDataAbertura() {
		return dataAbertura;
	}
	public void setDataAbertura(OffsetDateTime dataAbertura) {
		this.dataAbertura = dataAbertura;
	}
	public OffsetDateTime getDataFinalizacao() {
		return dataFinalizacao;
	}
	public void setDataFinalizacao(OffsetDateTime dataFinalizacao) {
		this.dataFinalizacao = dataFinalizacao;
	}
	public ClienteResumoModel getCliente() {
		return cliente;
	}
	public void setCliente(ClienteResumoModel cliente) {
		this.cliente = cliente;
	}
	
	
}
