package br.com.imd.MedSystem.business;

import java.util.ArrayList;

import javax.ejb.Stateless;

import br.com.imd.MedSystem.business.interfaces.CadastrarPacienteRemote;
import br.com.imd.MedSystem.dao.PacienteDAO;
import br.com.imd.MedSystem.domain.Paciente;


@Stateless
public class CadastrarPacienteBean implements CadastrarPacienteRemote {

	@Override
	public boolean registrarPaciente(String pNome, String mNome, String fNome, String dataNascimento, String cpf,
			String rg, String convenio) {
		
		Paciente paciente = new Paciente();
		
		paciente.setId_pessoa(0 + PacienteDAO.list().size());
		paciente.setId(0 + PacienteDAO.list().size() );
		paciente.setpNome(pNome);
		paciente.setmNome(mNome);
		paciente.setfNome(fNome);
		paciente.setDataNascimento(dataNascimento);
		paciente.setCpf(cpf);
		paciente.setRg(rg);
		paciente.setConvenio(convenio);
		
		PacienteDAO.add(paciente);
		
		return true;
	}

	@Override
	public ArrayList<Paciente> pacienteList() {

		return (ArrayList<Paciente>) PacienteDAO.list();
	}

	@Override
	public Paciente pacienteFindById(int id) {
		if(PacienteDAO.getById(id) != null) {
			return PacienteDAO.getById(id);
		}
		return null;
	}

	@Override
	public boolean deletePaciente(int id) {
		return PacienteDAO.delete(id);
	}

	@Override
	public boolean atualizarPaciente(Paciente paciente) {
		PacienteDAO.update(paciente, paciente.getId_pessoa()+ 1);
		return true;
	}

	@Override
	public ArrayList<Paciente> listaDeEspera() {
		ArrayList<Paciente> pacientes = new ArrayList<Paciente>();
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println((ArrayList<Paciente>) PacienteDAO.list());
		
		for(int i = 0 ; i < PacienteDAO.list().size() ; i++) {
			if(PacienteDAO.list().get(i).getStatus().equals("AGUARDANDO ACOLHIMENTO")) {
				pacientes.add(PacienteDAO.list().get(i));
			}
		}
		return (ArrayList<Paciente>) pacientes;
		
	}

	@Override
	public boolean mudarStatusPaciente(String pNome, String cpf, String status) {
		
		for(Paciente pacien : PacienteDAO.list()) {
			if (pacien.getpNome().equals(pNome) && pacien.getCpf().equals(cpf) ) {
				pacien.setStatus(status);
			}
		}
		return true;
	}

	
}
