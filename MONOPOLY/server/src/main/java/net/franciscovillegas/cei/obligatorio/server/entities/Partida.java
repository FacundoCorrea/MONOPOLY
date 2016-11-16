package net.franciscovillegas.cei.obligatorio.server.entities;

import java.util.List;

public class Partida {

	private List<Jugador> Jugadores;
	
	private List<Jugador> JugadoresEnJuego;
	
	private Tablero Tablero;
	
	private Mazo Mazo;

	public List<Jugador> getJugadores() {
		return Jugadores;
	}

	public void setJugadores(List<Jugador> jugadores) {
		Jugadores = jugadores;
	}

	public List<Jugador> getJugadoresEnJuego() {
		return JugadoresEnJuego;
	}

	public void setJugadoresEnJuego(List<Jugador> jugadoresEnJuego) {
		JugadoresEnJuego = jugadoresEnJuego;
	}

	public Tablero getTablero() {
		return Tablero;
	}

	public void setTablero(Tablero tablero) {
		Tablero = tablero;
	}

	public Mazo getMazo() {
		return Mazo;
	}

	public void setMazo(Mazo mazo) {
		Mazo = mazo;
	}

	public Partida(List<Jugador> jugadores, List<Jugador> jugadoresEnJuego,
			net.franciscovillegas.cei.obligatorio.server.entities.Tablero tablero,
			net.franciscovillegas.cei.obligatorio.server.entities.Mazo mazo) {
		super();
		Jugadores = jugadores;
		JugadoresEnJuego = jugadoresEnJuego;
		Tablero = tablero;
		Mazo = mazo;
	}
	
	
	
	
}
