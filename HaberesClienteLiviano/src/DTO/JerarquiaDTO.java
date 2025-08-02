package DTO;

import java.math.BigDecimal;

public class JerarquiaDTO extends DTO{
	
	private String nombre;
	private BigDecimal monto;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public BigDecimal getMonto() {
		return monto;
	}
	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}
	
	public String toString() {
		return this.getNombre();
	}
	
}
