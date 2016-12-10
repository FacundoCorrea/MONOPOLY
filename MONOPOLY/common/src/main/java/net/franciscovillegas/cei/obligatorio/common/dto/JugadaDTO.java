package net.franciscovillegas.cei.obligatorio.common.dto;

import java.io.Serializable;
import java.util.List;

public class JugadaDTO implements Serializable {
	
	private List<String> acciones;

	public List<String> getAcciones() {
		return acciones;
	}

	public void setAcciones(List<String> acciones) {
		this.acciones = acciones;
	}

	public JugadaDTO(List<String> acciones) {
		super();
		this.acciones = acciones;
	}


}
