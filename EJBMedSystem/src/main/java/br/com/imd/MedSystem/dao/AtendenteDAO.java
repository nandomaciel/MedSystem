package br.com.imd.MedSystem.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.imd.MedSystem.domain.Atendente;

public class AtendenteDAO {
	
	private static final List<Atendente> atendentes = new ArrayList<Atendente>();
	
	public static final Atendente getById(int id) {
		
		Atendente result = null;
		
		for(Atendente atendente : atendentes) {
			if(atendente.getId() == id) {
				result = atendente;
				break;
			}
		}
		return result;	
	}
	
	public static List<Atendente> list(){return atendentes;}
	
	public static Atendente add(Atendente atendente) {
		atendentes.add(atendente);
		atendente.setId(atendentes.indexOf(atendente) + 1);
		return atendente;
	}
	
	public static void update(Atendente atendente, int id) {
		atendentes.set(id - 1, atendente);
		atendente.setId(atendentes.indexOf(atendente) + 1);	
	}
	
	public static void delete(int id) {
		Atendente atendente = atendentes.get(id - 1);
		atendentes.remove(atendente);
	}
	
}
