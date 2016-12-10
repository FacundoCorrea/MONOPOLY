package net.franciscovillegas.cei.obligatorio.common;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import net.franciscovillegas.cei.obligatorio.common.dto.JugadorDTO;

public interface Observer extends Remote, Serializable {
	
	public void mostrarJugadores() throws RemoteException;
	
	public void empezarPartida(JugadorDTO jugador) throws RemoteException;
/////////////////////////////////////////////////////////////////////////////////////////
	public void sendMessage(String mensaje) throws RemoteException;
	
	public void actulizarTimer(int segundo) throws RemoteException;
	
	public void setJugador(JugadorDTO jugador) throws RemoteException;
	
	public JugadorDTO getJugador() throws RemoteException;
	
	public void actualizarPosicionJugador(int posAnterior, int jugadorPos, int posicion) throws RemoteException;
	
	public void cambiarTurno(int posJugador, JugadorDTO jugador) throws RemoteException;
	
	public void comprarPropiedad(JugadorDTO jugador, int posicion) throws RemoteException;
	
	public void acciones(JugadorDTO jugador, List<String> acciones) throws RemoteException;
	
	public void pagarMulta(JugadorDTO dueño, int cantidad) throws RemoteException;

}
