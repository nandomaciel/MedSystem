package visao;

import java.util.ArrayList;
import java.util.Map;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.com.imd.MedSystem.business.interfaces.AcolhimentoRemote;
import br.com.imd.MedSystem.business.interfaces.ConsultaRemote;
import br.com.imd.MedSystem.domain.Acolhimento;
import br.com.imd.MedSystem.domain.Paciente;

@Named(value = "consultaMB")
@RequestScoped
public class ConsultaMB {
	
	private String estadoPaciente;
	private String medicamentoReceitados;
	private String descExames;
	
	@EJB
	ConsultaRemote ejb;
	
	@EJB
	AcolhimentoRemote ejb3;
	
	public ArrayList<Paciente> pacienteList(){
		return ejb.pacienteDisponivelList();
	}
	
	public String iniciarConsultaMedica(int id) {
		
		Map<String,Object> sessionMapObj = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		
		Acolhimento acolhi = ejb3.acolhimentoFindById(id);
		
		sessionMapObj.put("PacienteObjEtapaMedico", acolhi);
		
		return "registroDeInformaçõesDeUmaConsulta";
	}
	
	public String registrarConsultaMedica(Acolhimento acolhimento) {
		ejb.registrarConsulta(acolhimento, estadoPaciente, medicamentoReceitados, descExames);
		
		return "atendimentoMedicoPage";
	}
	
	
	public String getEstadoPaciente() {
		return estadoPaciente;
	}
	public void setEstadoPaciente(String estadoPaciente) {
		this.estadoPaciente = estadoPaciente;
	}
	public String getMedicamentoReceitados() {
		return medicamentoReceitados;
	}
	public void setMedicamentoReceitados(String medicamentoReceitados) {
		this.medicamentoReceitados = medicamentoReceitados;
	}
	public String getDescExames() {
		return descExames;
	}
	public void setDescExames(String descExames) {
		this.descExames = descExames;
	}
	
	
	
	
	

}
