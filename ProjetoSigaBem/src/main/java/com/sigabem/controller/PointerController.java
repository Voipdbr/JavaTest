package com.sigabem.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sigabem.dataresult.req.RequestDataConsult;
import com.sigabem.dataresult.resp.ResponseDataConsult;
import com.sigabem.model.Output;
import com.sigabem.services.MathMethodServiceCalculate;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="API de consulta simples")
@Controller
@RequestMapping(value="/sigabem-api")
public class PointerController{
	
	@Autowired
	private MathMethodServiceCalculate completedService;
	
	// RequestParam API POST
	
	@ApiOperation(value="Criação de dados no banco de dados em que foi realizado o levantamento sobre o valor total do frete com ou sem desconto. (Esta busca é feita com RequestParam, neste caso, os comandos de acesso são utilizados pela url Query, onde na url estarão disponíveis os dados necessários para\r\n"
			+ "a consulta).")
	@RequestMapping(value="/input/query", method=RequestMethod.POST)
	public ResponseEntity<ResponseDataConsult> output1(@Valid @RequestParam(value="peso", required=true) Double peso, @RequestParam(value="cepOrigem", required=true) String cepOrigem, @RequestParam(value="cepDestino", required=true) String cepDestino,  @RequestParam(value="nomeDestinatario", required=true) String  nomeDestinatario, RequestDataConsult requestDC) {
		return ResponseEntity.ok().body(completedService.saveDatas(requestDC));
	}
	
	// Path Variables API POST
	
	@ApiOperation(value="Criação de dados no banco de dados em que foi realizado o levantamento sobre o valor total do frete com ou sem desconto. (Esta busca é feita com PathVariable em que a api simula uma busca sendo realizada a partir da implementação de pastas na url de busca).")
	@RequestMapping(value="/input/{peso}/{cepOrigem}/{cepDestino}/{nomeDestinatario}", method=RequestMethod.POST)
	public ResponseEntity<ResponseDataConsult> output2(@Valid @PathVariable("peso") Double peso, @PathVariable("cepOrigem") String cepOrigem, @PathVariable("cepDestino") String cepDestino,  @PathVariable("nomeDestinatario") String  nomeDestinatario, RequestDataConsult requestDC) {
		return ResponseEntity.ok().body(completedService.saveDatas(requestDC));
	}
	
	// JSON Request API POST
	
	@ApiOperation(value="Criação de dados no banco de dados em que foi realizado o levantamento sobre o valor total do frete com ou sem desconto. (Esta pesquisa é feita com RequestBody em JSON).")
	@RequestMapping(value="/input", method=RequestMethod.POST)
	public ResponseEntity<ResponseDataConsult> output3(@Valid @RequestBody RequestDataConsult requestDC) {
		return ResponseEntity.ok().body(completedService.saveDatas(requestDC));
	}
	
	@ApiOperation(value="Esta é uma operação na qual todos os dados de consulta que foram salvos no banco de dados serão listados.")
	@RequestMapping(value="/output", method=RequestMethod.GET)
	@ResponseBody
	public List < Output > output() {
		
		return completedService.findAll();
	}

}