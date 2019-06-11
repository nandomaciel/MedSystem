package br.com.imd.MedSystem.domain;

import java.io.Serializable;

public class Funcionario extends Pessoa implements Serializable {
	
	private int id;
	private int ssn;
	private int nis;
	private String setor;
	private String sex;
	private float salario;
	private String uf;
	
	
	
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSsn() {
		return ssn;
	}
	public void setSsn(int ssn) {
		this.ssn = ssn;
	}
	public int getNis() {
		return nis;
	}
	public void setNis(int nis) {
		this.nis = nis;
	}
	public String getSetor() {
		return setor;
	}
	public void setSetor(String setor) {
		this.setor = setor;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public float getSalario() {
		return salario;
	}
	public void setSalario(float salario) {
		this.salario = salario;
	}
	
	

}
