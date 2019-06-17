package br.com.imd.MedSystem.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.imd.MedSystem.domain.Login;

public class LoginDAO {
	private static final List<Login> loginList = new ArrayList<Login>();
	
	

	public static final Login getById(int id) {
			
		Login result = null;
			
		for(Login login : loginList) {
			if(login.getId() == id) {
				result = login;
				break;
			}
		}
		return result;	
	}
	
	public static List<Login> list(){return loginList;}
	
	public static Login add(Login login) {
		loginList.add(login);
		login.setId(loginList.indexOf(login) + 1);
		return login;
	}
	
	public static void update(Login login, int id) {
		loginList.set(id - 1, login);
		login.setId(loginList.indexOf(login) + 1);	
	}
	
	public static void delete(int id) {
		Login login = loginList.get(id - 1);
		loginList.remove(login);
	}
	
	
	

	
	
}
