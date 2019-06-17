package br.com.imd.MedSystem.business.interfaces;

import java.util.ArrayList;

import javax.ejb.Remote;

import br.com.imd.MedSystem.domain.Atendente;
import br.com.imd.MedSystem.domain.Enfermeiro;
import br.com.imd.MedSystem.domain.Medico;

@Remote
public interface CadastrarFuncionarioRemote {
	
	public boolean RegisterDoctor(
			String pNome, String mNome, String fNome, String dataNascimento, String cpf, String rg,
			int ssn, int nis, String setor, String sex, float salario, String uf,
			String crm, String especialidade, String login, String senha
			);
	public boolean RegisterReceptionist(
			String pNome, String mNome, String fNome, String dataNascimento, String cpf, String rg,
			int ssn, int nis, String setor, String sex, float salario, String uf,
			String setorDeAtendimento, String login, String senha
			);
	public boolean RegisterNurse(
			String pNome, String mNome, String fNome, String dataNascimento, String cpf, String rg,
			int ssn, int nis, String setor, String sex, float salario, String uf,
			String cofen, String login, String senha
			);
	
	public ArrayList<Medico> doctorList();
	
	public ArrayList<Enfermeiro> enfermeitoList();
	
	public ArrayList<Atendente> atendenteList();
	
	public Medico medicoFindById(int id);
	
	public Enfermeiro enfermeiroFindById(int id);
	
	public Atendente atendenteFindById(int id);
	
	public boolean deleteMedico(int id);
	
	public boolean atualizarMedico(Medico medico);
	
	public boolean atualizarAtendente(Atendente atendente);
	
	public boolean atualizarEnfermeiro(Enfermeiro enfermeiro);
	
	public boolean deleteAtendente(int id);
	
	public boolean deleteEnfermeiro(int id);
	
}
