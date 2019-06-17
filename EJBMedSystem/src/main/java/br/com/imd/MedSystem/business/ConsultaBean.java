package br.com.imd.MedSystem.business;

import java.util.ArrayList;

import javax.ejb.Stateless;

import br.com.imd.MedSystem.business.interfaces.ConsultaRemote;
import br.com.imd.MedSystem.dao.ConsultaDAO;
import br.com.imd.MedSystem.dao.PacienteDAO;
import br.com.imd.MedSystem.domain.Acolhimento;
import br.com.imd.MedSystem.domain.Consulta;
import br.com.imd.MedSystem.domain.Paciente;



@Stateless
public class ConsultaBean implements ConsultaRemote {

	@Override
	public ArrayList<Paciente> pacienteDisponivelList() {
		ArrayList<Paciente> pacientes = new ArrayList<Paciente>();
		for(int i = 0 ; i < PacienteDAO.list().size() ; i++) {
			if(PacienteDAO.list().get(i).getStatus().equals("AGUARDANDO CONSULTA")) {
				pacientes.add(PacienteDAO.list().get(i));
			}
		}
		return (ArrayList<Paciente>) pacientes;
	}

	@Override
	public boolean registrarConsulta(Acolhimento acolhimento, String estadoPaciente, String medicamentosReceitados,
			String descExames) {
		
		Consulta consul = new Consulta();
		
		consul.setId(acolhimento.getId());
		consul.setPacienteEstado(estadoPaciente);
		consul.setDescriExames(descExames);
		consul.setPacienteMedicamentos(medicamentosReceitados);
		
		mudarStatusPaciente(acolhimento.getId(), "ATENDIMENTO MEDICO FINALIZADO");
		ConsultaDAO.add(consul);
		return true;
	}
	
	public boolean mudarStatusPaciente(int id, String status) {
		
		for(Paciente pacien : PacienteDAO.list()) {
			if (pacien.getId() == id  || pacien.getId_pessoa() == id ) {
				pacien.setStatus(status);
			}
		}
		return true;
	}
	
}
