package controladores;

import java.util.Hashtable;
import java.util.List;
import DTO.PersonaDTO;
import DTO.TabuladoDTO;
import modelosVistas.PanelTabuladoNouModelView;
import modelosVistas.PanelTabuladosModelView;
import paneles.PanelTabuladoNou;
import paneles.PanelTabulados;
import servicios.ServicioPersonas;
import servicios.ServicioTabulados;
import vistas.VistaPrincipal;

public class TabuladosController {
	
	public static void getTabuladosLiquidacion(Long idLiquidacion,VistaPrincipal padre) {
		List <TabuladoDTO> tabulados=ServicioTabulados.getTabuladosPorLiquidacion(idLiquidacion);
		Hashtable<String, TabuladoDTO> hashTabulados= new Hashtable<String, TabuladoDTO>();
		
		PanelTabuladosModelView modelo=new PanelTabuladosModelView();
		for(TabuladoDTO tabulado:tabulados) {
			hashTabulados.put(String.valueOf(tabulado.getId()), tabulado);
		}
		
		modelo.setTabulados(hashTabulados);
		modelo.setPadre(padre);
		preTabuladosLiquidacion(modelo);
	}
	
	public static void preTabuladosLiquidacion(PanelTabuladosModelView modelo) {
		PanelTabulados panel=new PanelTabulados(modelo);
		modelo.getPadre().actualizarPanelCentral(panel);		
	}
	
	public static void preVisualizarTabulado(TabuladoDTO tabulado,VistaPrincipal padre) {
		PanelTabuladoNouModelView modelo= new PanelTabuladoNouModelView();
		modelo.setPadre(padre);

		PersonaDTO persona=ServicioPersonas.getPersonaNou(tabulado.getNou());
		TabuladoDTO tabuladoRecuperado=ServicioTabulados.getTabuladosPorId(tabulado.getId());
		
		modelo.setTabulado(tabuladoRecuperado);
		modelo.setPersona(persona);
		
		PanelTabuladoNou panel=new PanelTabuladoNou(modelo);
		padre.actualizarPanelCentral(panel);
		
	}

}
