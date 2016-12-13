package net.franciscovillegas.cei.obligatorio.common.dto;

import java.io.Serializable;

public class JugadorDTO implements Serializable {

	private String nombre;
	private String password;
	private int dinero;
	private int ganadas;
	private int perdidas;
	private boolean bancarrota = false;
	
	
	
	public boolean isBancarrota() {
		return bancarrota;
	}
	public void setBancarrota(boolean bancarrota) {
		this.bancarrota = bancarrota;
	}
	public int getDinero() {
		return dinero;
	}
	public void setDinero(int dinero) {
		this.dinero = dinero;
	}
	public int getGanadas() {
		return ganadas;
	}
	public void setGanadas(int ganadas) {
		this.ganadas = ganadas;
	}
	public int getPerdidas() {
		return perdidas;
	}
	public void setPerdidas(int perdidas) {
		this.perdidas = perdidas;
	}
	
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
	public JugadorDTO(String nombre, String password, int dinero, int ganadas, int perdidas) {
		super();
		this.nombre = nombre;
		this.password = password;
		this.dinero = dinero;
		this.ganadas = ganadas;
		this.perdidas = perdidas;
	}
	
	
	
	
	
}
