package net.franciscovillegas.cei.obligatorio.common.dto;

import java.io.Serializable;

public class JugadorDTO implements Serializable {

	private String nombre;
	private String password;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public JugadorDTO(String nombre, String password) {
		super();
		this.nombre = nombre;
		this.password = password;
	}
	
	
	
	
}
