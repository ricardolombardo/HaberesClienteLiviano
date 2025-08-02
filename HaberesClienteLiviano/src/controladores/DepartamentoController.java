package controladores;

import java.util.Hashtable;
import DTO.DepartamentoDTO;
import modelosVistas.PanelDepartamentosModelView;
import paneles.PanelDepartamentos;
import servicios.ServicioDepartamentos;
import vistas.VistaEditorDepartamento;
import vistas.VistaPrincipal;

public class DepartamentoController {
	
	public static void preVistaDepartamentos(VistaPrincipal padre){
		
		PanelDepartamentosModelView modelo=new PanelDepartamentosModelView();
		Hashtable<String,DepartamentoDTO>departamentos=new Hashtable<String,DepartamentoDTO>();
		
		for(DepartamentoDTO departamento: ServicioDepartamentos.getDepartametos()) {
			departamentos.put(String.valueOf(departamento.getId()), departamento);
		};
		
		modelo.setDepartamentos(departamentos);
		modelo.setPadre(padre);
		PanelDepartamentos panel=new PanelDepartamentos(modelo);
		padre.actualizarPanelCentral(panel);
		
	}
	
	public static void preNuevoDepartamento(VistaPrincipal padre, DepartamentoDTO departamento) {
		VistaEditorDepartamento ved=new VistaEditorDepartamento( padre, departamento);
		ved.setVisible(true);
	}
	
	public static void posEditarDepartamento(DepartamentoDTO persona,VistaPrincipal padre) {
		if(persona.getId()!=null) {
			ServicioDepartamentos.updateDepartamento(persona);
		}else {
				
		}
		preVistaDepartamentos(padre);
	}

}
