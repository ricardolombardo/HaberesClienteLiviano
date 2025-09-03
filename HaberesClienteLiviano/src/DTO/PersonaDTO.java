package DTO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PersonaDTO extends DTO{
	
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private DepartamentoDTO departamento;
	private JerarquiaDTO jerarquia;
	private TituloDTO titulo;
	private List<NOUDTO> nous;
	private int antiguedad;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public DepartamentoDTO getDepartamento() {
		return departamento;
	}

	public void setDepartamento(DepartamentoDTO departamento) {
		this.departamento = departamento;
	}

	public JerarquiaDTO getJerarquia() {
		return jerarquia;
	}

	public void setJerarquia(JerarquiaDTO jerarquia) {
		this.jerarquia = jerarquia;
	}

	public List<NOUDTO> getNous() {
		return nous;
	}

	public void setNous(List<NOUDTO> nous) {
		this.nous = nous;
	}

	public TituloDTO getTitulo() {
		return titulo;
	}

	public void setTitulo(TituloDTO titulo) {
		this.titulo = titulo;
	}

	public int getAntiguedad() {
		return antiguedad;
	}

	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}
	
}
