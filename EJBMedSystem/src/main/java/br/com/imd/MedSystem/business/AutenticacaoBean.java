package br.com.imd.MedSystem.business;

import javax.ejb.Stateless;

import br.com.imd.MedSystem.business.interfaces.AutenticacaoRemote;
import br.com.imd.MedSystem.dao.LoginDAO;
import br.com.imd.MedSystem.domain.Login;

@Stateless
public class AutenticacaoBean implements AutenticacaoRemote {

	@Override
	public String autenticar(String login, String senha) {
		if(LoginDAO.list().size() == 0) {
			Login loginObj = new Login();
			loginObj.setId(0 + LoginDAO.list().size());
			loginObj.setLogin("admin");
			loginObj.setSenha("admin");
			loginObj.setTipoFuncionario("ADMIN");
			
			LoginDAO.add(loginObj);
		}
		
		return verificarLogin(login,senha);
	}
	
	public String verificarLogin(String login, String senha) {
		for(Login logins : LoginDAO.list()) {
			if ( logins.getLogin().equals(login) && logins.getSenha().equals(senha)) {
				return logins.getTipoFuncionario();	
			}
		}
		return "";
	}
}
