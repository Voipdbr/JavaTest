package com.sigabem.dataresult.req;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


public class RequestDataConsult {

@NotEmpty(message = "O preenchimento desse campo é obrigatório para a aplicação!")
@Size(max = 100, message = "O nome do destinatário deve contar no máximo 100 caracteres.")
private String nomeDestinatario;

@NotEmpty(message = "O preenchimento desse campo é obrigatório para a aplicação!")
@Size(min = 8, max = 8, message = "O CEP deve no mínimo e no máximo 8 caracteres")
private String cepOrigem;

@NotEmpty(message = "O preenchimento desse campo é obrigatório para a aplicação!")
@Size(min = 8, max = 8, message = "O CEP deve no mínimo e no máximo ter 8 caracteres")
private String cepDestino;

private Double peso;

	public RequestDataConsult() {
	}
	
	public RequestDataConsult(String nomeDestinatario, String cepOrigem, String cepDestino, Double peso) {
		this.nomeDestinatario = nomeDestinatario;
		this.cepOrigem = cepOrigem;
		this.cepDestino = cepDestino;
		this.peso = peso;
	}
	
	public String getNomeDestinatario() {
		return nomeDestinatario;
	}
	
	public void setNomeDestinatario(String nomeDestinatario) {
		this.nomeDestinatario = nomeDestinatario;
	}
	
	public String getCepOrigem() {
		return cepOrigem;
	}
	
	public void setCepOrigem(String cepOrigem) {
		this.cepOrigem = cepOrigem;
	}
	
	public String getCepDestino() {
		return cepDestino;
	}
	
	public void setCepDestino(String cepDestino) {
		this.cepDestino = cepDestino;
	}
	
	public Double getPeso() {
		return peso;
	}
	
	public void setPeso(Double peso) {
		this.peso = peso;
	}

}
