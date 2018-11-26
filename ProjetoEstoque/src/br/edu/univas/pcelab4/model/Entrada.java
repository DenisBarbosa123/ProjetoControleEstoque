package br.edu.univas.pcelab4.model;

import java.util.Date;

public class Entrada {
	private int codigo_entrada;
	private Date dataEntrada;
	private String origemEntrada;
	
	
	public int getCodigo_entrada() {
		return codigo_entrada;
	}
	public void setCodigo_entrada(int codigo_entrada) {
		this.codigo_entrada = codigo_entrada;
	}
	public Date getDataEntrada() {
		return dataEntrada;
	}
	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
	public String getOrigemEntrada() {
		return origemEntrada;
	}
	public void setOrigemEntrada(String origemEntrada) {
		this.origemEntrada = origemEntrada;
	}
	
	
}
