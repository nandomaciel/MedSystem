package br.com.imd.MedSystem.business;

import java.util.ArrayList;

import javax.ejb.Stateless;

import br.com.imd.MedSystem.business.interfaces.CadastrarFuncionarioRemote;
import br.com.imd.MedSystem.dao.AtendenteDAO;
import br.com.imd.MedSystem.dao.EnfermeiroDAO;
import br.com.imd.MedSystem.dao.LoginDAO;
import br.com.imd.MedSystem.dao.MedicoDAO;
import br.com.imd.MedSystem.domain.Atendente;
import br.com.imd.MedSystem.domain.Enfermeiro;
import br.com.imd.MedSystem.domain.Login;
import br.com.imd.MedSystem.domain.Medico;


@Stateless
public class CadastrarFuncionarioBean implements CadastrarFuncionarioRemote {

	
	@Override
	public boolean RegisterDoctor(String pNome, String mNome, String fNome, String dataNascimento, String cpf,
			String rg, int ssn, int nis, String setor, String sex, float salario, String uf, String crm,
			String especialidade, String login, String senha) {
		
		Medico medico = new Medico();
		Login setLogin = new Login();
		
		medico.setId_pessoa(0 + MedicoDAO.list().size());
		medico.setpNome(pNome);
		medico.setmNome(mNome);
		medico.setfNome(fNome);
		medico.setDataNascimento(dataNascimento);
		medico.setCpf(cpf);
		medico.setRg(rg);
		medico.setSsn(ssn);
		medico.setNis(nis);
		medico.setSetor(setor);
		medico.setSex(sex);
		medico.setSalario(salario);
		medico.setUf(uf);
		medico.setCrm(crm);
		medico.setEspecialidade(especialidade);
		
		setLogin.setId(medico.getId_pessoa());
		setLogin.setLogin(login);
		setLogin.setSenha(senha);
		setLogin.setTipoFuncionario("MEDICO");
		
		medico.setUf(uf);
		medico.setEspecialidade(especialidade);
		
		MedicoDAO.add(medico);
		LoginDAO.add(setLogin);
				
		return true;
	}

	@Override
	public boolean RegisterReceptionist(String pNome, String mNome, String fNome, String dataNascimento, String cpf,
			String rg, int ssn, int nis, String setor, String sex, float salario, String uf, String setorDeAtendimento,
			String login, String senha) {
		
		Atendente atendente = new Atendente();
		Login setLogin = new Login();
		
		atendente.setId_pessoa(0 + AtendenteDAO.list().size());
		atendente.setpNome(pNome);
		atendente.setmNome(mNome);
		atendente.setfNome(fNome);
		atendente.setDataNascimento(dataNascimento);
		atendente.setCpf(cpf);
		atendente.setRg(rg);
		atendente.setSsn(ssn);
		atendente.setNis(nis);
		atendente.setSetor(setor);
		atendente.setSex(sex);
		atendente.setSalario(salario);
		atendente.setUf(uf);
		atendente.setSetorDeAtendimento(setorDeAtendimento);
		
		setLogin.setId(atendente.getId_pessoa());
		setLogin.setLogin(login);
		setLogin.setSenha(senha);
		setLogin.setTipoFuncionario("ATENDENTE");
		
		AtendenteDAO.add(atendente);
		LoginDAO.add(setLogin);
		return true;
	}
	

	@Override
	public boolean RegisterNurse(String pNome, String mNome, String fNome, String dataNascimento, String cpf, String rg,
			int ssn, int nis, String setor, String sex, float salario, String uf, String cofen, String login, String senha) {
		
		Enfermeiro enfermeiro = new Enfermeiro();
		Login setLogin = new Login();
		
		enfermeiro.setId_pessoa(0 + EnfermeiroDAO.list().size());
		enfermeiro.setpNome(pNome);
		enfermeiro.setmNome(mNome);
		enfermeiro.setfNome(fNome);
		enfermeiro.setDataNascimento(dataNascimento);
		enfermeiro.setCpf(cpf);
		enfermeiro.setRg(rg);
		enfermeiro.setSsn(ssn);
		enfermeiro.setNis(nis);
		enfermeiro.setSetor(setor);
		enfermeiro.setSex(sex);
		enfermeiro.setSalario(salario);
		enfermeiro.setUf(uf);
		enfermeiro.setCofen(cofen);
		
		setLogin.setId(enfermeiro.getId_pessoa());
		setLogin.setLogin(login);
		setLogin.setSenha(senha);
		setLogin.setTipoFuncionario("ENFERMEIRO");
		
		EnfermeiroDAO.add(enfermeiro);
		LoginDAO.add(setLogin);
		System.out.println(EnfermeiroDAO.list().get(0).getpNome());
		
		return true;
	}

	@Override
	public ArrayList<Medico> doctorList() {
		return (ArrayList<Medico>) MedicoDAO.list();
	}

	@Override
	public ArrayList<Enfermeiro> enfermeitoList() {
		return (ArrayList<Enfermeiro>) EnfermeiroDAO.list();
	}

	@Override
	public ArrayList<Atendente> atendenteList() {
		return (ArrayList<Atendente>) AtendenteDAO.list();
	}

	@Override
	public Medico medicoFindById(int id) {
		
		if(MedicoDAO.getById(id) != null) {
			return MedicoDAO.getById(id);
		}
		return null;
	}

	@Override
	public Enfermeiro enfermeiroFindById(int id) {
		if(EnfermeiroDAO.getById(id) != null) {
			return EnfermeiroDAO.getById(id);
		}
		return null;
	}

	@Override
	public Atendente atendenteFindById(int id) {
		if(AtendenteDAO.getById(id) != null) {
			return AtendenteDAO.getById(id);
		}
		return null;
	}

	@Override
	public boolean deleteMedico(int id) {
		return MedicoDAO.delete(id);
	}

	@Override
	public boolean atualizarMedico(Medico medico) {
		MedicoDAO.update(medico, medico.getId_pessoa() + 1);
		return true;
	}

	@Override
	public boolean atualizarAtendente(Atendente atendente) {
		AtendenteDAO.update(atendente, atendente.getId_pessoa()+ 1);
		return true;
	}

	@Override
	public boolean atualizarEnfermeiro(Enfermeiro enfermeiro) {
		EnfermeiroDAO.update(enfermeiro, enfermeiro.getId_pessoa() + 1);
		return false;
	}

	@Override
	public boolean deleteAtendente(int id) {
		return AtendenteDAO.delete(id);
	}

	@Override
	public boolean deleteEnfermeiro(int id) {
		return EnfermeiroDAO.delete(id);
	}
}
