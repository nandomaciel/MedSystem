package br.com.imd.MedSystem.model;

public class Funcionario extends Pessoa {
	
	private int id;
	private int ssn;
	private int nis;
	private int setor;
	private String sex;
	private float salario;
	
	
	
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
	public int getSetor() {
		return setor;
	}
	public void setSetor(int setor) {
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
