package modelosVistas;

import java.util.Hashtable;

import DTO.LiquidacionDTO;
import DTO.TabuladoDTO;

public class PanelTabuladosModelView extends ModelView{

	private Hashtable<String,TabuladoDTO> tabulados;
	private LiquidacionDTO liqudacion;

	public Hashtable<String, TabuladoDTO> getTabulados() {
		return tabulados;
	}

	public void setTabulados(Hashtable<String, TabuladoDTO> tabulados) {
		this.tabulados = tabulados;
	}

	public LiquidacionDTO getLiqudacion() {
		return liqudacion;
	}

	public void setLiqudacion(LiquidacionDTO liqudacion) {
		this.liqudacion = liqudacion;
	}
	
}
