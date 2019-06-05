package br.com.imd.MedSystem.dao;

import java.util.ArrayList;
import java.util.List;


import br.com.imd.MedSystem.domain.Enfermeiro;

public class EnfermeiroDAO {
	
	private static final List<Enfermeiro> enfermeiros = new ArrayList<Enfermeiro>();
	
	public static final Enfermeiro getById(int id) {
		
		Enfermeiro result = null;
		
		for(Enfermeiro enfermeiro : enfermeiros) {
			if(enfermeiro.getId() == id) {
				result = enfermeiro;
				break;
			}
		}
		return result;	
	}
	
	public static List<Enfermeiro> list(){return enfermeiros;}
	
	public static Enfermeiro add(Enfermeiro enfermeiro) {
		enfermeiros.add(enfermeiro);
		enfermeiro.setId(enfermeiros.indexOf(enfermeiro) + 1);
		return enfermeiro;
	}
	
	public static void update(Enfermeiro enfermeiro, int id) {
		enfermeiros.set(id - 1, enfermeiro);
		enfermeiro.setId(enfermeiros.indexOf(enfermeiro) + 1);	
	}
	
	public static void delete(int id) {
		Enfermeiro enfermeiro = enfermeiros.get(id - 1);
		enfermeiros.remove(enfermeiro);
	}
	

	

}
