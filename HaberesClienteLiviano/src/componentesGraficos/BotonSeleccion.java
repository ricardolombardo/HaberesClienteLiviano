package componentesGraficos;

import DTO.DTO;
import componentesVisuales.BotonSeleccionInterna;

public class BotonSeleccion extends BotonSeleccionInterna {
	
	private static final long serialVersionUID = 1L;
	private DTO dto;
	
	public BotonSeleccion(String texto) {
		super(texto);
	}

	public DTO getDto() {
		return dto;
	}

	public void setDto(DTO dto) {
		this.dto = dto;
	}
	
	

}
