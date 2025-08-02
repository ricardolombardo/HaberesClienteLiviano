package modelosVistas;

import java.util.List;

import DTO.EventoNOUDTO;
import DTO.PersonaDTO;

public class PanelEventosNouModelView extends ModelView{
	
	private List<EventoNOUDTO> eventosNOU;
	private PersonaDTO persona;

	public List<EventoNOUDTO> getEventosNOU() {
		return eventosNOU;
	}

	public void setEventosNOU(List<EventoNOUDTO> eventosNOU) {
		this.eventosNOU = eventosNOU;
	}

	public PersonaDTO getPersona() {
		return persona;
	}

	public void setPersona(PersonaDTO persona) {
		this.persona = persona;
	}
	
	

}
