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

@Controller
@RequestMapping(value="/sigabem-api")
public class PointerController{
	
	@Autowired
	private MathMethodServiceCalculate completedService;
	
	// RequestParam API POST
	
	@RequestMapping(value="/input/query", method=RequestMethod.POST)
	public ResponseEntity<ResponseDataConsult> output1(@Valid @RequestParam(value="peso", required=true) Double peso, @RequestParam(value="cepOrigem", required=true) String cepOrigem, @RequestParam(value="cepDestino", required=true) String cepDestino,  @RequestParam(value="nomeDestinatario", required=true) String  nomeDestinatario, RequestDataConsult requestDC) {
		return ResponseEntity.ok().body(completedService.saveDatas(requestDC));
	}
	
	// Path Variables API POST
	
	@RequestMapping(value="/input/{peso}/{cepOrigem}/{cepDestino}/{nomeDestinatario}", method=RequestMethod.POST)
	public ResponseEntity<ResponseDataConsult> output2(@Valid @PathVariable("peso") Double peso, @PathVariable("cepOrigem") String cepOrigem, @PathVariable("cepDestino") String cepDestino,  @PathVariable("nomeDestinatario") String  nomeDestinatario, RequestDataConsult requestDC) {
		return ResponseEntity.ok().body(completedService.saveDatas(requestDC));
	}
	
	// JSON Request API POST
	
	@RequestMapping(value="/input", method=RequestMethod.POST)
	public ResponseEntity<ResponseDataConsult> output3(@Valid @RequestBody RequestDataConsult requestDC) {
		return ResponseEntity.ok().body(completedService.saveDatas(requestDC));
	}
	
	@RequestMapping(value="/output", method=RequestMethod.GET)
	@ResponseBody
	public List < Output > output() {
		
		return completedService.findAll();
	}

}