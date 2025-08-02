package DTO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TabuladoDTO extends DTO{
	
	private String descripcion;
	private NOUDTO nou;
	private LiquidacionDTO liquidacion;
	private List<TabuladoConceptoDTO> tabuladoConceptos;
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public NOUDTO getNou() {
		return nou;
	}
	public void setNou(NOUDTO nou) {
		this.nou = nou;
	}
	public LiquidacionDTO getLiquidacion() {
		return liquidacion;
	}
	public void setLiquidacion(LiquidacionDTO liquidacion) {
		this.liquidacion = liquidacion;
	}
	public List<TabuladoConceptoDTO> getTabuladoConceptos() {
		return tabuladoConceptos;
	}
	public void setTabuladoConceptos(List<TabuladoConceptoDTO> tabuladoConceptos) {
		this.tabuladoConceptos = tabuladoConceptos;
	}
	
	
}
