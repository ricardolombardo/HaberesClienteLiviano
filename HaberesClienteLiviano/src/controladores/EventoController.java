package controladores;

import java.util.Hashtable;

import DTO.EventoDTO;
import DTO.LiquidacionDTO;
import modelosVistas.FiltroModelView;
import modelosVistas.PanelEventosModelView;
import paneles.PanelEventos;
import servicios.ServicioEventos;
import servicios.ServicioLiquidaciones;
import vistas.VistaEditorEvento;
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

	@Override
	public void ejecucionFiltro(FiltroModelView filtro) {
		// TODO Auto-generated method stub
		
	}

}
