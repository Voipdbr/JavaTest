package com.sigabem.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.sigabem.exceptionservice.InputOfCEPNotFoundException;
import com.sigabem.model.Input;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="API de consulta simples")
@Controller
@RequestMapping(value="/sigabem-api")
public class CepService {

	// This method create a API for localhost:8080/sigabem-api to consulting a CEP in localhost
	
	@ApiOperation(value="Esta é uma operação na qual o serviço de consulta do site (viacep.com.br) será executado e implementado em uma API localhost, podendo ser visualizado a partir do serviço local. (No início do projeto precisei criar este Serviço para visualizar os retornos dos parâmetros criados no model\r\n"
			+ " e se estava tudo ok.).")
	@GetMapping(value="/{cep}")	
    public ResponseEntity<Input> localcepService(@PathVariable(name = "cep") String cep){
		
		RestTemplate restTemplate = new RestTemplate();
	    RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
	   
	    restTemplate = restTemplateBuilder.build();

        UriComponents uri = UriComponentsBuilder.newInstance()
     		   .scheme("https")
     		   .host("viacep.com.br")
     		   .path("/ws/{cep}/json/")
     		   .build();
        
        Map<String, String> params = new HashMap<String, String>();
        params.put("cep", cep);

        ResponseEntity<Input> enderecoTO = restTemplate.getForEntity(uri.toUriString(), Input.class, params);
        
        new ResponseEntity<Input>(HttpStatus.OK);
        
        if(enderecoTO.getBody().getCep() == null){
            throw new InputOfCEPNotFoundException(cep);
        }

        return ResponseEntity.ok(enderecoTO).getBody();
    }
	
	// This method is the Service that queries the CEP in the external api.
	
    public Input cepService(String cep){
		
		RestTemplate restTemplate = new RestTemplate();
	    RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
	   
	    restTemplate = restTemplateBuilder.build();

        UriComponents uri = UriComponentsBuilder.newInstance()
     		   .scheme("https")
     		   .host("viacep.com.br")
     		   .path("/ws/{cep}/json/")
     		   .build();
        
        Map<String, String> params = new HashMap<String, String>();
        params.put("cep", cep);

        ResponseEntity<Input> enderecoTO = restTemplate.getForEntity(uri.toUriString(), Input.class, params);
        
        new ResponseEntity<Input>(HttpStatus.OK);
        
        if(enderecoTO.getBody().getCep() == null){
            throw new InputOfCEPNotFoundException(cep);
        }

        return enderecoTO.getBody();
    }

}
