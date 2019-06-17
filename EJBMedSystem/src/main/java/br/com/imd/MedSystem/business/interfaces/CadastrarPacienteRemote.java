package br.com.imd.MedSystem.business.interfaces;

import java.util.ArrayList;

import javax.ejb.Remote;

import br.com.imd.MedSystem.domain.Paciente;

@Remote
public interface CadastrarPacienteRemote {
	
	public boolean registrarPaciente(
			String pNome, String mNome, String fNome, 
			String dataNascimento, String cpf, String rg,
			String convenio);
	
	
	public ArrayList<Paciente> pacienteList();
	
	public Paciente pacienteFindById(int id);
	
	public boolean deletePaciente(int id);
	
	public boolean atualizarPaciente(Paciente paciente);
	
	public ArrayList<Paciente> listaDeEspera();
	
	public boolean mudarStatusPaciente(String pNome, String cpf, String status);
}
