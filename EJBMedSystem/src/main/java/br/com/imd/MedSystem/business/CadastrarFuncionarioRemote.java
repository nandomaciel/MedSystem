package br.com.imd.MedSystem.business;

import javax.ejb.Remote;

@Remote
public interface CadastrarFuncionarioRemote {
	public boolean cadastrarFuncionario(
			String nome, String cpf
			);
}
