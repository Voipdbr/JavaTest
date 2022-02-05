package com.sigabem.model;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Output")
public class Output implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private Double peso;
	private String cepOrigem;
	private String cepDestino;
	private String nomeDestinatario;
	private Double vlTotalFrete;
	private LocalDate dataPrevistaEntrega;
	private LocalDate dataConsulta;
	
	public Output(long id, Double peso, String cepOrigem, String cepDestino, String nomeDestinatario,
			Double vlTotalFrete, LocalDate dataPrevistaEntrega, LocalDate dataConsulta) {
		this.id = id;
		this.peso = peso;
		this.cepOrigem = cepOrigem;
		this.cepDestino = cepDestino;
		this.nomeDestinatario = nomeDestinatario;
		this.vlTotalFrete = vlTotalFrete;
		this.dataPrevistaEntrega = dataPrevistaEntrega;
		this.dataConsulta = dataConsulta;
	}
	
	public Output(double doubleValue, String format, String format2, String format3, Double test, LocalDate now,
			LocalDate now2, Object object, Object object2) {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Double getPeso() {
		return peso;
	}
	public String getCepOrigem() {
		return cepOrigem;
	}
	public String getCepDestino() {
		return cepDestino;
	}
	public String getNomeDestinatario() {
		return nomeDestinatario;
	}
	public Double getVlTotalFrete() {
		return vlTotalFrete;
	}
	public LocalDate getDataPrevistaEntrega() {
		return dataPrevistaEntrega;
	}
	public LocalDate getDataConsulta() {
		return dataConsulta;
	}
	
	
	

}