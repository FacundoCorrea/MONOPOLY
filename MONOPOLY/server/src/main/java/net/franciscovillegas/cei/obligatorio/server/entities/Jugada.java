package net.franciscovillegas.cei.obligatorio.server.entities;

import java.util.List;

public class Jugada {

	private Accion accionRealizada;
	private Jugador jugadorAnterior;
	private Jugador jugadorSiguiente;
	private List<Accion> accionesDisponibles;
	
	
	public Accion getAccionRealizada() {
		return accionRealizada;
	}
	public void setAccionRealizada(Accion accionRealizada) {
		this.accionRealizada = accionRealizada;
	}
	public Jugador getJugadorAnterior() {
		return jugadorAnterior;
	}
	public void setJugadorAnterior(Jugador jugadorAnterior) {
		this.jugadorAnterior = jugadorAnterior;
	}
	public Jugador getJugadorSiguiente() {
		return jugadorSiguiente;
	}
	public void setJugadorSiguiente(Jugador jugadorSiguiente) {
		this.jugadorSiguiente = jugadorSiguiente;
	}
	public List<Accion> getAccionesDisponibles() {
		return accionesDisponibles;
	}
	public void setAccionesDisponibles(List<Accion> accionesDisponibles) {
		this.accionesDisponibles = accionesDisponibles;
	}
	
	
}
