package modelosVistas;

import java.util.Hashtable;
import DTO.LiquidacionDTO;

public class PanelLiquidacionesModelView extends ModelView{
	
	private Hashtable<String,LiquidacionDTO> liquidaciones;

	public Hashtable<String, LiquidacionDTO> getLiquidaciones() {
		return liquidaciones;
	}

	public void setLiquidaciones(Hashtable<String, LiquidacionDTO> liquidaciones) {
		this.liquidaciones = liquidaciones;
	}

}
