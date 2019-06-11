package br.com.imd.MedSystem.business;

import java.util.ArrayList;

import javax.ejb.Stateless;

import br.com.imd.MedSystem.dao.AtendenteDAO;
import br.com.imd.MedSystem.dao.EnfermeiroDAO;
import br.com.imd.MedSystem.dao.MedicoDAO;
import br.com.imd.MedSystem.domain.Atendente;
import br.com.imd.MedSystem.domain.Enfermeiro;
import br.com.imd.MedSystem.domain.Medico;


@Stateless
public class CadastrarFuncionarioBean implements CadastrarFuncionarioRemote {

	
	@Override
	public boolean RegisterDoctor(String pNome, String mNome, String fNome, String dataNascimento, String cpf,
			String rg, int ssn, int nis, String setor, String sex, float salario, String uf, String crm,
			String especialidade) {
		
		Medico medico = new Medico();
		
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
		
		
		medico.setUf(uf);
		medico.setEspecialidade(especialidade);
		
		MedicoDAO.add(medico);
		System.out.println("Medico cadastrado 2.0 <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		
		System.out.println(MedicoDAO.list().get(0).getpNome());
		return true;
	}

	@Override
	public boolean RegisterReceptionist(String pNome, String mNome, String fNome, String dataNascimento, String cpf,
			String rg, int ssn, int nis, String setor, String sex, float salario, String uf, String setorDeAtendimento) {
		// TODO Auto-generated method stub
		Atendente atendente = new Atendente();
		
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
		
		AtendenteDAO.add(atendente);
		return true;
	}
	

	@Override
	public boolean RegisterNurse(String pNome, String mNome, String fNome, String dataNascimento, String cpf, String rg,
			int ssn, int nis, String setor, String sex, float salario, String uf, String cofen) {
		
		Enfermeiro enfermeiro = new Enfermeiro();
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
		
		EnfermeiroDAO.add(enfermeiro);
		
		return true;
	}

	@Override
	public ArrayList<Medico> doctorList() {
		return (ArrayList<Medico>) MedicoDAO.list();
	}

	@Override
	public ArrayList<Enfermeiro> enfermeitoList() {
		// TODO Auto-generated method stub
		return (ArrayList<Enfermeiro>) EnfermeiroDAO.list();
	}

	@Override
	public ArrayList<Atendente> atendenteList() {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Atendente atendenteFindById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteMedico(int id) {
		return MedicoDAO.delete(id);
	}

	

}
