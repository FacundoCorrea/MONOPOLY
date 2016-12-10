package net.franciscovillegas.cei.obligatorio.common.dto;

import java.io.Serializable;
import java.util.List;

public class AccionDTO implements Serializable{
	private List<String> acciones;
	
	public AccionDTO() {
		super();
	}
	
	public List<String> getAcciones() {
		return acciones;
	}

	public void setAcciones(List<String> acciones) {
		this.acciones = acciones;
	}

}

