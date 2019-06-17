package br.com.imd.MedSystem.business.interfaces;

import java.util.ArrayList;

import javax.ejb.Remote;

import br.com.imd.MedSystem.domain.Acolhimento;
import br.com.imd.MedSystem.domain.Paciente;
@Remote
public interface ConsultaRemote {
	
	public ArrayList<Paciente> pacienteDisponivelList();
	
	public boolean registrarConsulta(Acolhimento acolhimento, String estadoPaciente, String medicamentosReceitados, String descExames);

}
