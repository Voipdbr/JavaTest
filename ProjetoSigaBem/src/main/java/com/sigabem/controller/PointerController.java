package com.sigabem.controller;

import java.io.Serializable;
import java.net.URI;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.sigabem.model.Input;
import com.sigabem.model.Output;
import com.sigabem.repository.Repository;

@Controller
@RequestMapping(value="/sigabem-api")
public class PointerController{
	
//	@Autowired
//	private Repository inputRepository;
//	
//	private static final long serialVersionUID = 1615466078718957570L;
//
//	@GetMapping(value="/{cep}")
//	 public ResponseEntity<Input> doObterCep(@PathVariable(name = "cep") String cep) {
//		
//       RestTemplate restTemplate = new RestTemplate();
//       RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
//    
//       restTemplate = restTemplateBuilder.build();
//       
//       UriComponents uri = UriComponentsBuilder.newInstance()
//    		   .scheme("https")
//    		   .host("viacep.com.br")
//    		   .path("/ws/{cep}/json/")
//    		   .build();
//       
//	   Map<String, String> params = new HashMap<String, String>();
//	   params.put("cep", cep);
//	    
//	   ResponseEntity<Input> enderecoTO = restTemplate.getForEntity(uri.toUriString(), Input.class, params);
//	   Input input = inputRepository.findAll();
//	   
//	   new ResponseEntity<Input>(HttpStatus.OK);
//	   
//	   return ResponseEntity.ok(input).getBody();
//	 }
	
	@RequestMapping(value="/input/{peso}/{cepOrigem}/{cepDestino}/{nomeDestinatario}", method=RequestMethod.GET)
	@ResponseBody
	public Output output(@PathVariable("peso") Double peso, @PathVariable("cepOrigem") String cepOrigem, @PathVariable("cepDestino") String cepDestino,  @PathVariable("nomeDestinatario") String  nomeDestinatario) {

		Double test = 80.1;
		
		
		return new Output(
				peso.doubleValue(),
				String.format(cepOrigem),
				String.format(cepDestino),
				String.format(nomeDestinatario),
				test,
				LocalDate.now(),
				LocalDate.now(),
				null,
				null
				);
	}

}