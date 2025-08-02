package DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NOUDTO extends DTO{
	
	private int numeroNOU;
	private PersonaDTO persona;
	
	public PersonaDTO getPersona() {
		return persona;
	}
	public void setPersona(PersonaDTO persona) {
		this.persona = persona;
	}
	public int getNumeroNOU() {
		return numeroNOU;
	}
	public void setNumeroNOU(int numeroNOU) {
		this.numeroNOU = numeroNOU;
	}
	
	

}
