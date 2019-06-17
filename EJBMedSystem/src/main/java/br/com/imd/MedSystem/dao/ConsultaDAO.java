package br.com.imd.MedSystem.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.imd.MedSystem.domain.Consulta;

public class ConsultaDAO {
	
	private static final List<Consulta> consultas = new ArrayList<Consulta>();


	public static final Consulta getById(int id) {
		
		Consulta result = null;
		for(Consulta consulta : consultas) {
			if(consulta.getId() == id) {
				result = consulta;
				break;
			}
		}
		return result;	
	}
	
	public static List<Consulta> list(){return consultas;}
	
	public static Consulta add(Consulta consulta) {
		consultas.add(consulta);
		consulta.setId(consultas.indexOf(consulta) + 1);
		return consulta;
	}
	
	public static void update(Consulta consulta, int id) {
		consultas.set(id - 1, consulta);
		consulta.setId(consultas.indexOf(consulta) + 1);	
	}
	
	public static boolean delete(int id) {
		for(Consulta consul : consultas) {
			if ( consul.getId() == id - 1 ) {
				consultas.remove(consul);
				break;
			}
		}
		return true;
	}
	
	
	
	
	
	
	
}
