package br.com.imd.MedSystem.business.interfaces;

import javax.ejb.Remote;

@Remote
public interface AtendimentoRemote {
	public boolean iniciarAtendimento();
	public boolean encaminharPaciente();
	public boolean efetuarPagamento();
	
}
