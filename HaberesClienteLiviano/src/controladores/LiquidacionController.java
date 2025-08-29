package controladores;

import java.util.Hashtable;
import java.util.List;

import DTO.LiquidacionDTO;
import DTO.TabuladoDTO;
import DTO.TareaDTO;
import DTO.TareaLiquidacionDTO;
import modelosVistas.FiltroModelView;
import modelosVistas.PanelLiquidacionesModelView;
import modelosVistas.PanelTabuladosModelView;
import paneles.PanelLiquidaciones;
import servicios.ServicioLiquidaciones;
import servicios.ServicioTareas;
import vistas.VistaEditorLiquidacion;
import vistas.VistaEditorTareasLiquidacion;
import vistas.VistaPrincipal;

public class LiquidacionController extends UseCaseController{
	
	public static void preVisualizarLiquidaciones(VistaPrincipal padre) {
		
		PanelLiquidacionesModelView modelo=new PanelLiquidacionesModelView();
		Hashtable<String,LiquidacionDTO>liquidaciones=new Hashtable<String,LiquidacionDTO>();
		
		for(LiquidacionDTO liquidacion: ServicioLiquidaciones.getAll()) {
			liquidaciones.put(String.valueOf(liquidacion.getId()), liquidacion);
		};
		
		modelo.setLiquidaciones(liquidaciones);
		modelo.setPadre(padre);
		PanelLiquidaciones panel=new PanelLiquidaciones(modelo);
		padre.actualizarPanelCentral(panel);
		
	}
	
	@Override
	public void ejecucionFiltro(FiltroModelView filtro) {
		
		PanelLiquidacionesModelView modelo=new PanelLiquidacionesModelView();
		Hashtable<String,LiquidacionDTO>liquidaciones=new Hashtable<String,LiquidacionDTO>();
		
		for(LiquidacionDTO liquidacion: ServicioLiquidaciones.getLiquidacionesFiltradas(filtro.getAnioDesde(), filtro.getMesDesde(), filtro.getAnioHasta(), filtro.getMesHasta())) {
			liquidaciones.put(String.valueOf(liquidacion.getId()), liquidacion);
		};
		
		modelo.setLiquidaciones(liquidaciones);
		modelo.setPadre(filtro.getPadre());
		PanelLiquidaciones panel=new PanelLiquidaciones(modelo);
		panel.setearFiltro(filtro);
		filtro.getPadre().actualizarPanelCentral(panel);
		
	}
	
	
	public static void posVerTabuladosLiquidacion(LiquidacionDTO liquidacion,VistaPrincipal padre) {
		
		List <TabuladoDTO> tabulados=liquidacion.getTabulados();
		Hashtable<String, TabuladoDTO> hashTabulados= new Hashtable<String, TabuladoDTO>();
		
		PanelTabuladosModelView modelo=new PanelTabuladosModelView();
		for(TabuladoDTO tabulado:tabulados) {
			hashTabulados.put(String.valueOf(tabulado.getId()), tabulado);
		}
		
		modelo.setTabulados(hashTabulados);
		modelo.setPadre(padre);
		TabuladosController.preTabuladosLiquidacion(modelo);
		
	}
	
	public static void preNuevaLiquidacion(VistaPrincipal padre,LiquidacionDTO liquidacion,FiltroModelView filtro) {
		VistaEditorLiquidacion vel=new VistaEditorLiquidacion(padre,liquidacion,filtro);
		vel.setVisible(true);
		
	}
	
	public static void posNuevaLiquidacion(VistaPrincipal padre,LiquidacionDTO liquidacion,FiltroModelView filtro) {
		ServicioLiquidaciones.crearLiquidacion(liquidacion);
		//preVisualizarLiquidaciones(padre);
		LiquidacionController controlador=new LiquidacionController();
		controlador.ejecucionFiltro(filtro);
	}
	
	public static void preLiquidar(LiquidacionDTO liquidacionSeleccionada,FiltroModelView filtro) {
		ServicioLiquidaciones.liquidar(liquidacionSeleccionada);
		LiquidacionController controlador=new LiquidacionController();
		controlador.ejecucionFiltro(filtro);
	}
	
	public static void preEditarLiquidacion(LiquidacionDTO liquidacionSeleccionada,FiltroModelView filtro) {
		List<TareaDTO> tareas=ServicioTareas.getTareas();
		List<TareaLiquidacionDTO>tareasLiquidacion=ServicioTareas.getTareaLiquidacion(liquidacionSeleccionada.getId());
		liquidacionSeleccionada.setTareas(tareasLiquidacion);
		VistaEditorTareasLiquidacion vet=new VistaEditorTareasLiquidacion(liquidacionSeleccionada,tareas,filtro);
		vet.setVisible(true);
		
	}
	
	public static void preCrearTareasLiquidacion(List<TareaLiquidacionDTO> tareas,FiltroModelView filtro) {
		ServicioTareas.crearTareaLiquidacion(tareas);
		LiquidacionController controlador=new LiquidacionController();
		controlador.ejecucionFiltro(filtro);
	}

}
