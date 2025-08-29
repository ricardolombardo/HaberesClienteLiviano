package controladores;

import java.util.Hashtable;
import java.util.List;

import DTO.DepartamentoDTO;
import DTO.JerarquiaDTO;
import DTO.NOUDTO;
import DTO.PersonaDTO;
import DTO.TituloDTO;
import modelosVistas.PanelDatosPersonaModelView;
import modelosVistas.PanelPersonasModelView;
import paneles.PanelDatosPersona;
import paneles.PanelPersonas;
import servicios.ServicioDepartamentos;
import servicios.ServicioJerarquias;
import servicios.ServicioNous;
import servicios.ServicioPersonas;
import servicios.ServicioTitulos;
import vistas.VistaEditorPersona;
import vistas.VistaPrincipal;

public class PersonaController {

	public static void preVisualizarPersonas(VistaPrincipal padre) {
		
		PanelPersonasModelView modelo=new PanelPersonasModelView();
		Hashtable<String,PersonaDTO>personas=new Hashtable<String,PersonaDTO>();
		
		for(PersonaDTO persona: ServicioPersonas.gePersonas()) {
			personas.put(String.valueOf(persona.getId()), persona);
		};
		
		modelo.setPersonas(personas);
		modelo.setPadre(padre);
		PanelPersonas panel=new PanelPersonas(modelo);
		padre.actualizarPanelCentral(panel);
		
	}
	
	public static void preEditarPersona(PersonaDTO persona,VistaPrincipal padre) {
		List<DepartamentoDTO> departamentos=ServicioDepartamentos.getDepartametos();
		List<JerarquiaDTO> jerarquias=ServicioJerarquias.getJerarquias();
		List<TituloDTO> titulos=ServicioTitulos.getTitulos();
		
		VistaEditorPersona vep=new VistaEditorPersona(padre,persona,departamentos,jerarquias,titulos);
		vep.setVisible(true);
	}
	
	public static void posEditarPersona(PersonaDTO persona,VistaPrincipal padre) {
		if(persona.getId()!=null) {
			ServicioPersonas.updatePersona(persona);	
		}else {
			ServicioPersonas.createPersona(persona);	
		}
		preVisualizarPersonas(padre);
	}
	
	public static void preVisualizarDatosPersona(PersonaDTO persona,VistaPrincipal padre) {
		
		PanelDatosPersonaModelView modelo=new PanelDatosPersonaModelView();
		List<NOUDTO> nous=ServicioNous.getNousPersona(persona.getId());
		if(nous!=null) {
			persona.setNous(nous);	
		}
		modelo.setPadre(padre);
		modelo.setPersona(persona);
		PanelDatosPersona vdp=new PanelDatosPersona(modelo);
		padre.actualizarPanelCentral(vdp);
	}
	
}
