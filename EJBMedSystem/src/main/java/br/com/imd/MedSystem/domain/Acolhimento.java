package br.com.imd.MedSystem.domain;

import java.io.Serializable;

public class Acolhimento implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private double temperatura;
	private double pressao;
	private double batimentos;
	private String alergias;
	private String medicamentoUtilizados;
	private String doencasCronicas;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getTemperatura() {
		return temperatura;
	}
	public void setTemperatura(double temperatura) {
		this.temperatura = temperatura;
	}
	public double getPressao() {
		return pressao;
	}
	public void setPressao(double pressao) {
		this.pressao = pressao;
	}
	public double getBatimentos() {
		return batimentos;
	}
	public void setBatimentos(double batimentos) {
		this.batimentos = batimentos;
	}
	public String getAlergias() {
		return alergias;
	}
	public void setAlergias(String alergias) {
		this.alergias = alergias;
	}
	public String getMedicamentoUtilizados() {
		return medicamentoUtilizados;
	}
	public void setMedicamentoUtilizados(String medicamentoUtilizados) {
		this.medicamentoUtilizados = medicamentoUtilizados;
	}
	public String getDoencasCronicas() {
		return doencasCronicas;
	}
	public void setDoencasCronicas(String doencasCronicas) {
		this.doencasCronicas = doencasCronicas;
	}
	
	

}
