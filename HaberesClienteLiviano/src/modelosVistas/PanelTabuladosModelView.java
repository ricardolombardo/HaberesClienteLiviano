package modelosVistas;

import java.util.Hashtable;
import DTO.TabuladoDTO;

public class PanelTabuladosModelView extends ModelView{

	private Hashtable<String,TabuladoDTO> tabulados;

	public Hashtable<String, TabuladoDTO> getTabulados() {
		return tabulados;
	}

	public void setTabulados(Hashtable<String, TabuladoDTO> tabulados) {
		this.tabulados = tabulados;
	}
	
	
	
}
