package br.com.imd.MedSystem.domain;

import java.io.Serializable;

public class Atendente extends Funcionario implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idAtendente;
	private String setorDeAtendimento;
	
	
	
	
	public int getIdAtendente() {
		return idAtendente;
	}
	public void setIdAtendente(int idAtendente) {
		this.idAtendente = idAtendente;
	}
	public String getSetorDeAtendimento() {
		return setorDeAtendimento;
	}
	public void setSetorDeAtendimento(String setorDeAtendimento) {
		this.setorDeAtendimento = setorDeAtendimento;
	}
	
	
	
	
	

}
