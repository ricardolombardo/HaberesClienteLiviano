package modelosVistas;

import DTO.PersonaDTO;
import DTO.TabuladoDTO;

public class PanelTabuladoNouModelView extends ModelView{
	
	private TabuladoDTO tabulado;
	private PersonaDTO persona;

	public TabuladoDTO getTabulado() {
		return tabulado;
	}

	public void setTabulado(TabuladoDTO tabulado) {
		this.tabulado = tabulado;
	}

	public PersonaDTO getPersona() {
		return persona;
	}

	public void setPersona(PersonaDTO persona) {
		this.persona = persona;
	}
	
	

}
