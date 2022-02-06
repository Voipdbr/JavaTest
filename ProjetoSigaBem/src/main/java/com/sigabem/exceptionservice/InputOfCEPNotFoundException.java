package com.sigabem.exceptionservice;

public class InputOfCEPNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InputOfCEPNotFoundException(String cep) {
		super("CEP: " + cep + " Não EXISTE! Adicione um CEP válido...");
	}
}
