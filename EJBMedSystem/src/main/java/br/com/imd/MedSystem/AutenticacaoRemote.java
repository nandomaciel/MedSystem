package br.com.imd.MedSystem;

import javax.ejb.Remote;

@Remote
public interface AutenticacaoRemote {
	public boolean autenticar(String login, String senha);
}
