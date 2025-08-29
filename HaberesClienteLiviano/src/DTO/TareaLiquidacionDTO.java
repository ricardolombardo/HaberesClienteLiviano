package DTO;

public class TareaLiquidacionDTO extends DTO{
	
	private LiquidacionDTO liquidacion;
	private int orden;
	private String estadoEjecucion;
    private String nombreTarea;
    private String descripcionTarea;
    private Long idTarea;
    private Long idLiquidacion;
	
	public String getNombreTarea() {
		return nombreTarea;
	}

	public void setNombreTarea(String nombreTarea) {
		this.nombreTarea = nombreTarea;
	}

	public String getDescripcionTarea() {
		return descripcionTarea;
	}

	public void setDescripcionTarea(String descripcionTarea) {
		this.descripcionTarea = descripcionTarea;
	}

	public LiquidacionDTO getLiquidacion() {
		return liquidacion;
	}
	
	public void setLiquidacion(LiquidacionDTO liquidacion) {
		this.liquidacion = liquidacion;
	}
	
	public int getOrden() {
		return orden;
	}
	
	public void setOrden(int orden) {
		this.orden = orden;
	}
	
	public String getEstadoEjecucion() {
		return estadoEjecucion;
	}
	
	public void setEstadoEjecucion(String estadoEjecucion) {
		this.estadoEjecucion = estadoEjecucion;
	}

	public Long getIdTarea() {
		return idTarea;
	}

	public void setIdTarea(Long idTarea) {
		this.idTarea = idTarea;
	}

	public Long getIdLiquidacion() {
		return idLiquidacion;
	}

	public void setIdLiquidacion(Long idLiquidacion) {
		this.idLiquidacion = idLiquidacion;
	}
	
	
}
