package net.franciscovillegas.cei.obligatorio.server.entities;

import java.util.List;

import net.franciscovillegas.cei.obligatorio.common.dto.JugadorDTO;

public class Jugada {

	private Accion accionRealizada;
	private JugadorDTO jugadorAnterior;
	private JugadorDTO jugadorSiguiente;
	private List<Accion> accionesDisponibles;
	
	
	public Accion getAccionRealizada() {
		return accionRealizada;
	}
	public void setAccionRealizada(Accion accionRealizada) {
		this.accionRealizada = accionRealizada;
	}
	public JugadorDTO getJugadorAnterior() {
		return jugadorAnterior;
	}
	public void setJugadorAnterior(JugadorDTO jugadorAnterior) {
		this.jugadorAnterior = jugadorAnterior;
	}
	public JugadorDTO getJugadorSiguiente() {
		return jugadorSiguiente;
	}
	public void setJugadorSiguiente(JugadorDTO jugadorSiguiente) {
		this.jugadorSiguiente = jugadorSiguiente;
	}
	public List<Accion> getAccionesDisponibles() {
		return accionesDisponibles;
	}
	public void setAccionesDisponibles(List<Accion> accionesDisponibles) {
		this.accionesDisponibles = accionesDisponibles;
	}
	
	
}
