package modelosVistas;

import java.util.Hashtable;

import DTO.DepartamentoDTO;

public class PanelDepartamentosModelView extends ModelView{
	
	private Hashtable<String,DepartamentoDTO> departamentos;
	
	public PanelDepartamentosModelView(){
	}

	public Hashtable<String, DepartamentoDTO> getDepartamentos() {
		return departamentos;
	}

	public void setDepartamentos(Hashtable<String, DepartamentoDTO> departamentos) {
		this.departamentos = departamentos;
	}

}
