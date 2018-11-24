package br.edu.univas.pcelab4.model;

import java.util.Date;

public class Saida {
	private int codigoSaida;
	private Date dataSaida;
	private String destino;
	
	//getters and setters
	
	public int getCodigoSaida() {
		return codigoSaida;
	}
	public void setCodigoSaida(int codigoSaida) {
		this.codigoSaida = codigoSaida;
	}
	public Date getDataSaida() {
		return dataSaida;
	}
	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	
	
	
	
}
