package com.sigabem.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sigabem.dataresult.req.RequestDataConsult;
import com.sigabem.dataresult.resp.ResponseDataConsult;
import com.sigabem.model.Input;
import com.sigabem.model.Output;
import com.sigabem.repository.Repository;

@Service
public class MathMethodServiceCalculate {
	
	@Autowired
	private Repository repository;
	
	@Autowired
	private CepService cepService;
	
	public List < Output > findAll(){
		return repository.findAll();
	}
	
	public ResponseDataConsult saveDatas(RequestDataConsult requestDC) {
		
		Output outputResponse = RDCOutput(requestDC);
		
		outputResponse.setDataConsulta(LocalDate.now());
		outputResponse.setVlTotalFrete(MathTotalShip(requestDC));
		outputResponse.setDataPrevistaEntrega(ExpectedShippingData(requestDC, outputResponse.getDataConsulta()));

		return InputOutput((Output) repository.save(outputResponse));
		
	}

	public ResponseDataConsult InputOutput(Output output) {
		ResponseDataConsult responseDC = new ResponseDataConsult();
		
		responseDC.setCepOrigem(output.getCepOrigem());
		responseDC.setCepDestino(output.getCepDestino());
		responseDC.setVlTotalFrete(output.getVlTotalFrete());
		responseDC.setDataPrevistaEntrega(output.getDataPrevistaEntrega());
		
		return responseDC;
	}
	
	public Output RDCOutput(RequestDataConsult requestDC) {
		Output outputResponse = new Output();
		
		outputResponse.setCepOrigem(requestDC.getCepOrigem());
		outputResponse.setCepDestino(requestDC.getCepDestino());
		outputResponse.setPeso(requestDC.getPeso());
		outputResponse.setNomeDestinatario(requestDC.getNomeDestinatario());
		
		return outputResponse;
		
	}
	
	public Double MathTotalShip(RequestDataConsult requestDC) {
		Input cepOrigem = cepService.cepService(requestDC.getCepOrigem());
		Input cepDestino = cepService.cepService(requestDC.getCepDestino());
		
		return requestDC.getPeso() * CepMathCalculate(cepOrigem, cepDestino);

	}
	
	public LocalDate ExpectedShippingData(RequestDataConsult requestDC, LocalDate dateNow){
		
		Input cepOrigem = cepService.cepService(requestDC.getCepOrigem());
		Input cepDestino = cepService.cepService(requestDC.getCepDestino());
		Long ExpectedDaysForDelivery = DateShipReceive(cepOrigem, cepDestino);
		
		return dateNow.plusDays(ExpectedDaysForDelivery);
		
	}
	
	public Double CepMathCalculate(Input cepOrigem, Input cepDestino) {
		if(Objects.equals(cepOrigem.getUf(), cepDestino.getUf())) {
			return 0.25;
		}
		
		if(Objects.equals(cepOrigem.getDdd(), cepDestino.getDdd())) {
			return 0.5;
		}
		
		return 1.0;
	}
	
	public Long DateShipReceive(Input cepOrigem, Input cepDestino) {
		
		if(Objects.equals(cepOrigem.getUf(), cepDestino.getUf())) {
			return 1L;
		}
		
		if(Objects.equals(cepOrigem.getDdd(), cepDestino.getDdd())) {
			return 3L;
		}
		
		return 10L;
		
	}
}
