package br.com.imd.MedSystem.business;

import javax.ejb.Stateless;

@Stateless
public class AutenticacaoBean implements AutenticacaoRemote {

	@Override
	public boolean autenticar(String login, String senha) {
		//autentica��o via BD futuramente
		return "admin".equals(login) && "admin".equals(senha);
	}

}
