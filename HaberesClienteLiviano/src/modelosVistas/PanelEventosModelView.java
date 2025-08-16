package modelosVistas;

import java.util.Hashtable;
import DTO.EventoDTO;

public class PanelEventosModelView extends ModelView{
	
	private Hashtable<String,EventoDTO> eventos;

	public Hashtable<String,EventoDTO> getEventos() {
		return eventos;
	}

	public void setEventos(Hashtable<String,EventoDTO> eventos) {
		this.eventos = eventos;
	}
	
	

}
