package br.com.imd.MedSystem.domain;

import java.io.Serializable;

public class Enfermeiro extends Funcionario implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idEnfermeiro;
	private String cofen;
	
	public int getIdEnfermeiro() {
		return idEnfermeiro;
	}
	public void setId(int idEnfermeiro) {
		this.idEnfermeiro = idEnfermeiro;
	}
	public String getCofen() {
		return cofen;
	}
	public void setCofen(String cofen) {
		this.cofen = cofen;
	}
}
