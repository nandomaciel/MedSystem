package visao;

import java.util.ArrayList;
import java.util.Map;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.com.imd.MedSystem.business.interfaces.AcolhimentoRemote;
import br.com.imd.MedSystem.business.interfaces.CadastrarPacienteRemote;
import br.com.imd.MedSystem.domain.Paciente;

@Named(value = "acolhimentoMB")
@RequestScoped
public class AcolhimentoMB {
	
	private double temperatura;
	private double pressao;
	private double batimentos;
	private String alergias;
	private String medicamentoUtilizados;
	private String doencasCronicas;
	
	@EJB
	AcolhimentoRemote ejb;
	
	@EJB
	CadastrarPacienteRemote ejb2;
	
	public ArrayList<Paciente> pacienteList(){
		return ejb.pacienteDisponivelList();
	}
	
	public String registrarAcolhimento(Paciente paciente) {
		ejb.registrarAcolhimento(paciente, temperatura, pressao, batimentos, alergias, medicamentoUtilizados, doencasCronicas);
		ejb2.mudarStatusPaciente(paciente.getpNome(), paciente.getCpf(), "AGUARDANDO CONSULTA");
		return "atendimentoEnfermeiroPage";
	}
	
	public String iniciarAcolhimento(int id) {
		
		Map<String,Object> sessionMapObj = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		
		Paciente pacienteedit = ejb2.pacienteFindById(id);
		
		sessionMapObj.put("PacienteObj", pacienteedit);
		
		return "registroDeInfomaçõesDeUmAcolhimento";
		
	}

	public double getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(double temperatura) {
		this.temperatura = temperatura;
	}

	public double getPressao() {
		return pressao;
	}

	public void setPressao(double pressao) {
		this.pressao = pressao;
	}

	public double getBatimentos() {
		return batimentos;
	}

	public void setBatimentos(double batimentos) {
		this.batimentos = batimentos;
	}

	public String getAlergias() {
		return alergias;
	}

	public void setAlergias(String alergias) {
		this.alergias = alergias;
	}

	public String getMedicamentoUtilizados() {
		return medicamentoUtilizados;
	}

	public void setMedicamentoUtilizados(String medicamentoUtilizados) {
		this.medicamentoUtilizados = medicamentoUtilizados;
	}

	public String getDoencasCronicas() {
		return doencasCronicas;
	}

	public void setDoencasCronicas(String doencasCronicas) {
		this.doencasCronicas = doencasCronicas;
	}
	
	
	
	
	

}
