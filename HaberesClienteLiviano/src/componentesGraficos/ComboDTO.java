package componentesGraficos;

import java.util.List;
import javax.swing.JComboBox;
import DTO.DTO;

public class ComboDTO extends JComboBox<DTO>{
	private static final long serialVersionUID = 1L;
	private DTO dto;

	public ComboDTO() {
		
	}
	
	public ComboDTO(List<DTO> items) {
		this.addItems(items);
	}
	
	public DTO getDto() {
		return dto;
	}

	public void setDto(DTO dto) {
		this.dto = dto;
	}
	
	public void addItems(List<DTO> items) {
		for(DTO item:items) {
			this.addItem(item);
		}
	}
}
