package controladores;

import java.util.List;

import DTO.EventoNOUDTO;
import DTO.PersonaDTO;
import modelosVistas.PanelEventosNouModelView;
import paneles.PanelEventosNou;
import servicios.ServicioNous;
import vistas.VistaPrincipal;

public class NOUController {
	
	public static void preRecuperarEventosNou(Long id,VistaPrincipal padre, PersonaDTO persona) {
		
		List<EventoNOUDTO> eventosNou=ServicioNous.getEventosNou(id);
		
		PanelEventosNouModelView modelo=new PanelEventosNouModelView();
		modelo.setPadre(padre);
		modelo.setEventosNOU(eventosNou);
		modelo.setPersona(persona);
		
		PanelEventosNou vista=new PanelEventosNou(modelo);
		padre.actualizarPanelCentral(vista);
	}

}
