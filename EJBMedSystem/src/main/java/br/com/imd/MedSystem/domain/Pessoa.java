package br.com.imd.MedSystem.domain;

import java.io.Serializable;

public class Pessoa implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id_pessoa;
	private String pNome;
	private String mNome;
	private String fNome;
	private String dataNascimento;
	private String cpf;
	private String rg;
	
	
	
	public int getId_pessoa() {
		return id_pessoa;
	}
	public void setId_pessoa(int id_pessoa) {
		this.id_pessoa = id_pessoa;
	}
	public String getpNome() {
		return pNome;
	}
	public void setpNome(String pNome) {
		this.pNome = pNome;
	}
	public String getmNome() {
		return mNome;
	}
	public void setmNome(String mNome) {
		this.mNome = mNome;
	}
	public String getfNome() {
		return fNome;
	}
	public void setfNome(String fNome) {
		this.fNome = fNome;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	
	
	

}
