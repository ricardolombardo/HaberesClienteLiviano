package DTO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LiquidacionDTO extends DTO{
	
	private List<TabuladoDTO> tabulados;
	private int anio;
	private int mes;
	private String descripcion;
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public List<TabuladoDTO> getTabulados() {
		return tabulados;
	}
	public void setTabulados(List<TabuladoDTO> tabulados) {
		this.tabulados = tabulados;
	}
	public int getAnio() {
		return anio;
	}
	public void setAnio(int anio) {
		this.anio = anio;
	}
	public int getMes() {
		return mes;
	}
	public void setMes(int mes) {
		this.mes = mes;
	}
	
}
