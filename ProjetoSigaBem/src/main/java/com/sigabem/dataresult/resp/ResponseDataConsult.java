package com.sigabem.dataresult.resp;
import java.time.LocalDate;

public class ResponseDataConsult {
	
	private String cepOrigem;
    private String cepDestino;
    private LocalDate dataPrevistaEntrega;
    private Double vlTotalFrete;

    public ResponseDataConsult() {
    }

    public ResponseDataConsult(String cepOrigem, String cepDestino, LocalDate dataPrevistaEntrega, Double vlTotalFrete) {
        this.cepOrigem = cepOrigem;
        this.cepDestino = cepDestino;
        this.dataPrevistaEntrega = dataPrevistaEntrega;
        this.vlTotalFrete = vlTotalFrete;
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

    public LocalDate getDataPrevistaEntrega() {
        return dataPrevistaEntrega;
    }

    public void setDataPrevistaEntrega(LocalDate dataPrevistaEntrega) {
        this.dataPrevistaEntrega = dataPrevistaEntrega;
    }

    public Double getVlTotalFrete() {
        return vlTotalFrete;
    }

    public void setVlTotalFrete(Double vlTotalFrete) {
        this.vlTotalFrete = vlTotalFrete;
    }
}
