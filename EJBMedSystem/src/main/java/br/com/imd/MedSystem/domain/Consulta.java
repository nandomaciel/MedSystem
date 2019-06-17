package br.com.imd.MedSystem.domain;

public class Consulta {
	
	private int id;
	private String pacienteEstado;
	private String pacienteMedicamentos;
	private String descriExames;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPacienteEstado() {
		return pacienteEstado;
	}
	public void setPacienteEstado(String pacienteEstado) {
		this.pacienteEstado = pacienteEstado;
	}
	public String getPacienteMedicamentos() {
		return pacienteMedicamentos;
	}
	public void setPacienteMedicamentos(String pacienteMedicamentos) {
		this.pacienteMedicamentos = pacienteMedicamentos;
	}
	public String getDescriExames() {
		return descriExames;
	}
	public void setDescriExames(String descriExames) {
		this.descriExames = descriExames;
	}
	
	

}
