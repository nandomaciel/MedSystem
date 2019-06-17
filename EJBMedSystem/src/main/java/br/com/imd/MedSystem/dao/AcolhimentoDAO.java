package br.com.imd.MedSystem.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.imd.MedSystem.domain.Acolhimento;

public class AcolhimentoDAO {

	private static final List<Acolhimento> acolhimentos = new ArrayList<Acolhimento>();

	public static final Acolhimento getById(int id) {
		
		Acolhimento result = null;
		for(Acolhimento acolhimento : acolhimentos) {
			if(acolhimento.getId() == id) {
				result = acolhimento;
				break;
			}
		}
		return result;	
	}
	
	public static List<Acolhimento> list(){return acolhimentos;}

	
	
	public static Acolhimento add(Acolhimento acolhimento) {
		acolhimentos.add(acolhimento);
		acolhimento.setId(acolhimentos.indexOf(acolhimento) + 1);
		return acolhimento;
	}
	
	
	public static void update(Acolhimento acolhimento, int id) {
		acolhimentos.set(id - 1, acolhimento);
		acolhimento.setId(acolhimentos.indexOf(acolhimento) + 1);	
	}
	
	
	public static boolean delete(int id) {
		for(Acolhimento acolhi : acolhimentos) {
			if ( acolhi.getId() == id - 1 ) {
				acolhimentos.remove(acolhi);
				break;
			}
		}
		return true;
	}
	
}
