package br.com.imd.MedSystem.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.imd.MedSystem.domain.Paciente;

public class PacienteDAO {
	
	private static final List<Paciente> pacientes = new ArrayList<Paciente>();
	
	public static final Paciente getById(int id) {
		
		Paciente result = null;
		for(Paciente paciente : pacientes) {
			if(paciente.getId() == id) {
				result = paciente;
				break;
			}
		}
		return result;	
	}
	
	public static List<Paciente> list(){return pacientes;}
	

	
	public static Paciente add(Paciente paciente) {
		pacientes.add(paciente);
		paciente.setId(pacientes.indexOf(paciente) + 1);
		return paciente;
	}
	
	public static void update(Paciente paciente, int id) {
		pacientes.set(id - 1, paciente);
		paciente.setId(pacientes.indexOf(paciente) + 1);	
	}
	
	public static boolean delete(int id) {
		for(Paciente pacien : pacientes) {
			if ( pacien.getId_pessoa() == id - 1 ) {
				pacientes.remove(pacien);
				break;
			}
		}
		return true;
	}
	

	
	
	
	
	
	
	

}
