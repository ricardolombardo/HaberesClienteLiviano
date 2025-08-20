package controladores;

import java.util.Hashtable;
import java.util.List;

import DTO.EventoDTO;
import DTO.EventoNOUDTO;
import DTO.LiquidacionDTO;
import DTO.NOUDTO;
import DTO.PersonaDTO;
import modelosVistas.FiltroModelView;
import modelosVistas.PanelEventosModelView;
import paneles.PanelEventos;
import servicios.ServicioEventos;
import servicios.ServicioLiquidaciones;
import servicios.ServicioNous;
import servicios.ServicioPersonas;
import vistas.VistaEditorEvento;
import vistas.VistaEditorEventoNOU;
import vistas.VistaPrincipal;

public class EventoController extends UseCaseController{
	
	public static void preVisualizarEventos(VistaPrincipal padre) {
		
		PanelEventosModelView modelo=new PanelEventosModelView();
		Hashtable<String,EventoDTO>eventos=new Hashtable<String,EventoDTO>();
		
		for(EventoDTO evento: ServicioEventos.getEventos()) {
			eventos.put(String.valueOf(evento.getId()), evento);
		};
		
		modelo.setEventos(eventos);
		modelo.setPadre(padre);
		PanelEventos panel=new PanelEventos(modelo);
		padre.actualizarPanelCentral(panel);
		
	}
	
	public static void preNuevoEvento(VistaPrincipal padre) {
		VistaEditorEvento vee=new VistaEditorEvento(padre, new EventoDTO());
		vee.setVisible(true);
		
	}
	
	public static void posNuevoEvento(VistaPrincipal padre,EventoDTO evento) {
		ServicioEventos.crearEvento(evento);
		preVisualizarEventos(padre);
	}
	
	public static void preNuevoEventoNOU(VistaPrincipal padre,NOUDTO nou) {
		List<EventoDTO>eventos=ServicioEventos.getEventos();
		VistaEditorEventoNOU vee=new VistaEditorEventoNOU(padre,new EventoNOUDTO(),eventos,nou);
		vee.setVisible(true);
	}
	
	public static void posNuevoEventoNOU(VistaPrincipal padre,EventoNOUDTO evento,NOUDTO nou) {
		ServicioEventos.crearEventoNOU(evento,nou.getId());
		PersonaDTO persona = ServicioPersonas.getPersonaNou(nou);
		NOUController.preRecuperarEventosNou(nou,padre,persona);
	}

	@Override
	public void ejecucionFiltro(FiltroModelView filtro) {
		// TODO Auto-generated method stub
		
	}

}
