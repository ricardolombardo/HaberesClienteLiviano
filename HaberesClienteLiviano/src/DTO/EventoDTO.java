package DTO;

public class EventoDTO extends DTO{
	
	private String descripcion;
	private String identificador;

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	
	public String toString() {
		return this.descripcion;
	}

}
