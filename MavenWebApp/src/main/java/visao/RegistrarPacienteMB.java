package visao;

import java.util.ArrayList;
import java.util.Map;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.com.imd.MedSystem.business.interfaces.CadastrarPacienteRemote;
import br.com.imd.MedSystem.domain.Paciente;


@Named(value = "registrarPacienteMB")
@RequestScoped
public class RegistrarPacienteMB {
	
	private String pNome;
	
	private String mNome;
 
	private String fNome;
 
	private String dataNascimento;
	private String cpf;
	private String rg;
	
	private String convenio;
	
	private static final String status = "AGUARDANDO ACOLHIMENTO";
	
	@EJB
	private CadastrarPacienteRemote ejb;
	
	public String registrarPaciente() {
		
		ejb.registrarPaciente(pNome, mNome, fNome, dataNascimento, cpf, rg, convenio);
		
		return "pacientesCadastradosList";
	}
	
	public ArrayList<Paciente> getpacienteList() {
		return ejb.pacienteList();
	}
	
	public String updatePaciente(Paciente editPacienteObj) {
		
		ejb.atualizarPaciente(editPacienteObj);
		
		return "pacientesCadastradosList";
	}
	
	public String deletePaciente(int id) {
		if(ejb.deletePaciente(id)) {
			return "pacientesCadastradosList";
		}
		return "";
	}
	
	public ArrayList<Paciente> listaDeEspera() {
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>");
		return ejb.listaDeEspera();
	}
	
	public String atualizarPagina() {return "listaDeEsperaAtendimento";}
	
	public String editPacienteRecord(int id) {
		
		Map<String,Object> sessionMapObj = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		
		Paciente pacienteEdit = ejb.pacienteFindById(id);
		
		sessionMapObj.put("editPacienteObj", pacienteEdit);	
		
		return "editarPaciente";
	}
	
	public String addListaDeEspera() {
		if(ejb.mudarStatusPaciente(pNome, cpf, status)) {
			return "listaDeEsperaAtendimento";
		}
		return "";
	}
	
	
	
	public String getStatus() {
		return status;
	}
	
	public String getConvenio() {
		return convenio;
	}
	public void setConvenio(String convenio) {
		this.convenio = convenio;
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
	
	
	
	
	

}
