package controladores;

import java.util.Hashtable;

import DTO.JerarquiaDTO;
import modelosVistas.PanelJerarquiasModelView;
import paneles.PanelJerarquias;
import servicios.ServicioJerarquias;
import vistas.VistaPrincipal;

public class JerarquiaController {

	public static void preVisualizarJerarquias(VistaPrincipal padre) {
		
		PanelJerarquiasModelView modelo=new PanelJerarquiasModelView();
		Hashtable<String,JerarquiaDTO>jerarquias=new Hashtable<String,JerarquiaDTO>();
		
		for(JerarquiaDTO jerarquia: ServicioJerarquias.getJerarquias()) {
			jerarquias.put(String.valueOf(jerarquia.getId()), jerarquia);
		};
		
		modelo.setJerarquias(jerarquias);
		modelo.setPadre(padre);
		PanelJerarquias panel=new PanelJerarquias(modelo);
		padre.actualizarPanelCentral(panel);
		
	}
	
}
