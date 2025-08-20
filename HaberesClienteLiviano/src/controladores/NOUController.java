package controladores;

import java.util.List;

import javax.swing.JOptionPane;

import DTO.EventoNOUDTO;
import DTO.NOUDTO;
import DTO.PersonaDTO;
import excepciones.NOUException;
import modelosVistas.PanelEventosNouModelView;
import paneles.PanelEventosNou;
import servicios.ServicioNous;
import vistas.VistaEditorNou;
import vistas.VistaPrincipal;

public class NOUController {
	
	public static void preRecuperarEventosNou(NOUDTO nou,VistaPrincipal padre, PersonaDTO persona) {
		
		List<EventoNOUDTO> eventosNou=ServicioNous.getEventosNou(nou.getId());
		
		PanelEventosNouModelView modelo=new PanelEventosNouModelView();
		modelo.setPadre(padre);
		modelo.setEventosNOU(eventosNou);
		modelo.setPersona(persona);
		
		PanelEventosNou vista=new PanelEventosNou(modelo,nou);
		padre.actualizarPanelCentral(vista);
	}
	
	public static void preCrearNou(VistaPrincipal padre,PersonaDTO persona) {
		VistaEditorNou vee=new VistaEditorNou(padre,persona);
		vee.setVisible(true);
	}
	
	public static void posCrearNou(VistaPrincipal padre,NOUDTO nou){
		try {
			ServicioNous.crearNou(nou);
			PersonaController.preVisualizarDatosPersona(nou.getPersona(), padre);
		}catch(NOUException e) {
			JOptionPane.showMessageDialog(padre, e);
		}
		
	}

}
