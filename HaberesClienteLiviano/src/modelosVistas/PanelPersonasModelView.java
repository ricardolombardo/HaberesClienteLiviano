package modelosVistas;

import java.util.Hashtable;
import DTO.PersonaDTO;

public class PanelPersonasModelView extends ModelView{
	
	private Hashtable<String,PersonaDTO> personas;
	
	public PanelPersonasModelView(){
	}

	public Hashtable<String, PersonaDTO> getPersonas() {
		return personas;
	}

	public void setPersonas(Hashtable<String, PersonaDTO> personas) {
		this.personas = personas;
	}

}
