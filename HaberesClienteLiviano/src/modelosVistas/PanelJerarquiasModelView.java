package modelosVistas;

import java.util.Hashtable;

import DTO.JerarquiaDTO;

public class PanelJerarquiasModelView extends ModelView{
	
	private Hashtable<String,JerarquiaDTO> jerarquias;

	public Hashtable<String, JerarquiaDTO> getJerarquias() {
		return jerarquias;
	}

	public void setJerarquias(Hashtable<String, JerarquiaDTO> jerarquias) {
		this.jerarquias = jerarquias;
	}
	
	

}
