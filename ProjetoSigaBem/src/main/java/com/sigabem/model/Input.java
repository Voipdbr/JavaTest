package com.sigabem.model;

import java.io.Serializable;

public class Input implements Serializable {

	private static final long serialVersionUID = 3948535543737126816L;
	
	private String cep;
    private String ddd;
    
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getDdd() {
		return ddd;
	}
	public void setDdd(String ddd) {
		this.ddd = ddd;
	}
	
}
