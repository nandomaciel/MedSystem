package visao;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.imd.MedSystem.business.AutenticacaoRemote;

import javax.ejb.EJB;

@ManagedBean
public class LoginMB {

	private String login;
	private String senha;

	@EJB
	private AutenticacaoRemote ejb;
	
	public String autenticar() {
		if(ejb.autenticar(login, senha)) {
			return "principal";
		}
		else {
			FacesMessage fm = new FacesMessage("Login ou Senha Invalido");
			FacesContext.getCurrentInstance().addMessage("msg", fm);
			return null;
		}
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}
