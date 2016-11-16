package net.franciscovillegas.cei.obligatorio.server.entities;

import java.util.List;

public class Tablero {

	private List<Casillero> Casilleros;

	public List<Casillero> getCasilleros() {
		return Casilleros;
	}

	public void setCasilleros(List<Casillero> casilleros) {
		Casilleros = casilleros;
	}

	public Tablero(List<Casillero> casilleros) {
		super();
		Casilleros = casilleros;
	}
	
	
}
