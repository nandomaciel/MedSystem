package br.com.imd.MedSystem.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.imd.MedSystem.domain.Medico;

public class MedicoDAO {
	
	private static final List<Medico> medicos = new ArrayList<Medico>();
	
	public static final Medico getById(int id) {
		
		Medico result = null;
		for(Medico medico : medicos) {
			if(medico.getId() == id) {
				result = medico;
				break;
			}
		}
		return result;	
	}
	
	public static List<Medico> list(){return medicos;}
	
	public static Medico add(Medico medico) {
		medicos.add(medico);
		medico.setId(medicos.indexOf(medico) + 1);
		return medico;
	}
	
	public static void update(Medico medico, int id) {
		medicos.set(id - 1, medico);
		medico.setId(medicos.indexOf(medico) + 1);	
	}
	
	public static boolean delete(int id) {
		for(Medico med : medicos) {
			System.out.println(med.getId_pessoa() + "id<<<" + id);
			if ( med.getId_pessoa() == id - 1 ) {
				System.out.println("chegou no medico dao");
				medicos.remove(med);
				break;
			}
		}
		return true;
	}
}
