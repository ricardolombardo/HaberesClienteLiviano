package DTO;

import java.math.BigDecimal;

public class TabuladoConceptoDTO extends DTO{
	
	private ConceptoDTO concepto;
	private String sentido;
	private BigDecimal monto;
	
	public ConceptoDTO getConcepto() {
		return concepto;
	}
	public void setConcepto(ConceptoDTO concepto) {
		this.concepto = concepto;
	}
	public String getSentido() {
		return sentido;
	}
	public void setSentido(String sentido) {
		this.sentido = sentido;
	}
	public BigDecimal getMonto() {
		return monto;
	}
	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}
	
	

}
