package br.com.imd.MedSystem.business;

import javax.ejb.Stateless;

@Stateless
public class AutenticacaoBean implements AutenticacaoRemote {

	@Override
	public boolean autenticar(String login, String senha) {
		//autenticação via BD futuramente
		return "admin".equals(login) && "admin".equals(senha);
	}

}
