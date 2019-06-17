package br.com.imd.MedSystem.business.interfaces;

import javax.ejb.Remote;

@Remote
public interface AutenticacaoRemote {
	public String autenticar(String login, String senha);
}
