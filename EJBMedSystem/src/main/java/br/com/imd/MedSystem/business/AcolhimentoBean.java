package br.com.imd.MedSystem.business;

import java.util.ArrayList;

import javax.ejb.Stateless;

import br.com.imd.MedSystem.business.interfaces.AcolhimentoRemote;
import br.com.imd.MedSystem.dao.AcolhimentoDAO;
import br.com.imd.MedSystem.dao.PacienteDAO;
import br.com.imd.MedSystem.domain.Acolhimento;
import br.com.imd.MedSystem.domain.Paciente;

@Stateless
public class AcolhimentoBean implements AcolhimentoRemote {

	@Override
	public ArrayList<Paciente> pacienteDisponivelList() {
		
		ArrayList<Paciente> pacientes = new ArrayList<Paciente>();
		for(int i = 0 ; i < PacienteDAO.list().size() ; i++) {
			if(PacienteDAO.list().get(i).getStatus().equals("AGUARDANDO ACOLHIMENTO")) {
				pacientes.add(PacienteDAO.list().get(i));
			}
		}
		return (ArrayList<Paciente>) pacientes;
	}

	@Override
	public boolean registrarAcolhimento(
			Paciente paciente, double temperatura, double pressao, double batimentos,
			String alergias, String Medicamentos, String doencasCronicas) {
		
		Acolhimento acolhimento = new Acolhimento();
		
		acolhimento.setId(paciente.getId());
		acolhimento.setTemperatura(temperatura);
		acolhimento.setPressao(pressao);
		acolhimento.setBatimentos(batimentos);
		acolhimento.setAlergias(alergias);
		acolhimento.setMedicamentoUtilizados(Medicamentos);
		acolhimento.setDoencasCronicas(doencasCronicas);
		
		AcolhimentoDAO.add(acolhimento);
		return true;
	}

	@Override
	public Acolhimento acolhimentoFindById(int id) {
		if(AcolhimentoDAO.getById(id) != null) {
			return AcolhimentoDAO.getById(id);
		}
		return null;
	}
	
	

}
