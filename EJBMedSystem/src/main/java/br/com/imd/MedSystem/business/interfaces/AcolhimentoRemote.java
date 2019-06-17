package br.com.imd.MedSystem.business.interfaces;

import java.util.ArrayList;

import javax.ejb.Remote;

import br.com.imd.MedSystem.domain.Acolhimento;
import br.com.imd.MedSystem.domain.Paciente;

@Remote
public interface AcolhimentoRemote {
	
	public ArrayList<Paciente> pacienteDisponivelList();
	
	public boolean registrarAcolhimento(Paciente paciente, double temperatura, double pressao, double batimentos,
			String alergias, String Medicamentos, String doencasCronicas);
	
	
	public Acolhimento acolhimentoFindById(int id);
}
