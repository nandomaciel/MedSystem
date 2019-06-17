package visao;

import java.util.ArrayList;
import java.util.Map;

import javax.ejb.EJB;

import br.com.imd.MedSystem.business.interfaces.CadastrarFuncionarioRemote;
import br.com.imd.MedSystem.domain.Atendente;
import br.com.imd.MedSystem.domain.Enfermeiro;
import br.com.imd.MedSystem.domain.Medico;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;

@Named(value = "registerEmployeeMB")
@RequestScoped
public class RegisterEmployeeMB {
	 
	private String pNome;
	
	private String mNome;
 
	private String fNome;
 
	private String dataNascimento;
	private String cpf;
	private String rg;
	
	private int ssn;
	private int nis;
	private String setor;
	private String sex;
	private float salario;
	
	private String uf;
	
	private String login;
	private String senha;
	
	
	//Caso o Funcionario seja um medico
	private String crm;
	private String especialidade;
	
	// Caso o funcionario seja um Enfermeiro
	private String cofen;
	
	//Caso o funcionario seja um Atendente
	private String setorDeAtendimento;
	
	@EJB
	private CadastrarFuncionarioRemote ejb;
	
	public String registerEmployeeType(int tipo) {
		
		if(tipo== 1) {
			String result = verificarCamposNulos(tipo);
			
			if(result.equals("EmployeeList")) {
			ejb.RegisterDoctor(pNome, mNome, fNome, dataNascimento, cpf, rg, ssn, nis, setor, sex, salario, uf, crm, especialidade, login, senha);
			}
			
			return result;
		}
		
		if (tipo == 2) {
			String result = verificarCamposNulos(tipo);
			
			if(result.equals("EmployeeList")) {
				ejb.RegisterNurse(pNome, mNome, fNome, dataNascimento, cpf, rg, ssn, nis, setor, sex, salario, uf, cofen, login, senha);
			}
			return result;
		}
		
		if(tipo == 3 ) {
			String result = verificarCamposNulos(tipo);
			
			if(result.equals("EmployeeList")) {
			ejb.RegisterReceptionist(pNome, mNome, fNome, dataNascimento, cpf, rg, ssn, nis, setor, sex, salario, uf, setorDeAtendimento, login, senha );
			}
			return result;
		}	
		return null;	
	}
	
	
	public ArrayList<Medico> getDoctorList() {
		return ejb.doctorList();
	}
	
	public ArrayList<Enfermeiro> getEnfermeiroList(){
		return ejb.enfermeitoList();
	}
	
	public ArrayList<Atendente> getAtendenteList(){
		return ejb.atendenteList();
	}
	
	public String editDoctorRecord(int id) {
		
		Map<String,Object> sessionMapObj = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		
		Medico medicoEdit = ejb.medicoFindById(id);
		
		sessionMapObj.put("editDoctorObj", medicoEdit);	
		
		return "editDoctorPage";
	}
	
	public String editEnfermeiroToRecord(int id) {
		
		Map<String,Object> sessionMapObj = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		
		Enfermeiro enfermeiroEdit = ejb.enfermeiroFindById(id);
		
		sessionMapObj.put("editEnfermeiroObj", enfermeiroEdit);
		
		return "editarEnfermeiro";
	}
	
	
	public String editAtendenteToRecord(int id) {
		
		Map<String,Object> sessionMapObj = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		
		Atendente atendenteEdit = ejb.atendenteFindById(id);
		
		sessionMapObj.put("editAtendenteObj", atendenteEdit);
		
		return "editarAtendente";
	}
	
	
	
	public String updateDoctor(Medico editDoctorObj) {
		
		ejb.atualizarMedico(editDoctorObj);
		
		return "EmployeeList";
	}
	
	public String updateEnfermeiro(Enfermeiro enfermeiro) {
		ejb.atualizarEnfermeiro(enfermeiro);
		return "EmployeeList";
	}
	
	public String updateAtendente(Atendente atendente) {
		ejb.atualizarAtendente(atendente);
		return "EmployeeList";
	}
	
	public String deleteDoctor(int id) {
		if(ejb.deleteMedico(id)) {
			return "EmployeeList";
		}
		return "";
	}
	
	public String deleteEnfermeiro(int id) {
		
		if(ejb.deleteEnfermeiro(id)) {
			return "EmployeeList";
		}
		return "";
	}
	
	public String deleteAtendente(int id) {
		
		if(ejb.deleteAtendente(id)) {
			return "EmployeeList";
		}
		return "";
	}
	
	
	public String verificarCamposNulos(int tipo) {
		String resultado = "";
		
		boolean falhou = false;
		if( "".equals(pNome) || "".equals(mNome) || "".equals(fNome) )
		{	
			FacesContext.getCurrentInstance().addMessage("invalido",
					new FacesMessage(" Campo First name, Middle name, Last Name devem ser preechidos"));
			falhou = true;
			
		}
		if("".equals(dataNascimento) || "".equals(cpf) || "".equals(rg) ) {
			FacesContext.getCurrentInstance().addMessage("invalido",
					new FacesMessage(" Campo data de nascimento, cpf e RG devem ser preechidos"));
					falhou = true;
		}
		if("".equals(ssn) || "".equals(nis) || "".equals(setor)) {
			FacesContext.getCurrentInstance().addMessage("invalido",
					new FacesMessage(" Campo ssn, nis e setor devem ser preechidos"));
					falhou = true;
		}
		if("".equals(sex) || "".equals(salario) || "".equals(uf)) {
			FacesContext.getCurrentInstance().addMessage("invalido",
					new FacesMessage(" Campo Sexo, Salario e UF devem ser preechidos"));
					falhou = true;
		}
		
		if(tipo == 1) {
			if("".equals(crm) || "".equals(especialidade)) {
				FacesContext.getCurrentInstance().addMessage("invalido",
						new FacesMessage(" Campo CRM, e Especialidade devem ser preechidos"));
						falhou = true;
			}
		}
		if(tipo == 2 ) {
			if("".equals(cofen)) {
				FacesContext.getCurrentInstance().addMessage("invalido",
						new FacesMessage(" Campo cofen deve ser preechido"));
						falhou = true;
			}
			
		}
		
		if(tipo == 3) {
			if("".equals(setorDeAtendimento)) {
				FacesContext.getCurrentInstance().addMessage("invalido",
						new FacesMessage(" Campo setor de atendimento deve ser preechido"));
						falhou = true;
			}
		}
		
		if(!falhou) {
			resultado = "EmployeeList";
		}else {
			resultado =  "falhaNaAutenticacao";
		}
		return resultado;
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


	public String getpNome() {
		return pNome;
	}
	public void setpNome(String pNome) {
		this.pNome = pNome;
	}
	public String getmNome() {
		return mNome;
	}
	public void setmNome(String mNome) {
		this.mNome = mNome;
	}
	public String getfNome() {
		return fNome;
	}
	public void setfNome(String fNome) {
		this.fNome = fNome;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public int getSsn() {
		return ssn;
	}
	public void setSsn(int ssn) {
		this.ssn = ssn;
	}
	public int getNis() {
		return nis;
	}
	public void setNis(int nis) {
		this.nis = nis;
	}
	public String getSetor() {
		return setor;
	}
	public void setSetor(String setor) {
		this.setor = setor;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public float getSalario() {
		return salario;
	}
	public void setSalario(float salario) {
		this.salario = salario;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getCrm() {
		return crm;
	}
	public void setCrm(String crm) {
		this.crm = crm;
	}
	public String getEspecialidade() {
		return especialidade;
	}
	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
	public String getCofen() {
		return cofen;
	}
	public void setCofen(String cofen) {
		this.cofen = cofen;
	}
	public String getSetorDeAtendimento() {
		return setorDeAtendimento;
	}
	public void setSetorDeAtendimento(String setorDeAtendimento) {
		this.setorDeAtendimento = setorDeAtendimento;
	}
	
	
	
	
	
	
	
	

}
