package net.franciscovillegas.cei.obligatorio.common;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import net.franciscovillegas.cei.obligatorio.common.dto.JugadorDTO;

public interface PartidaController extends Remote {
	
	public void agregarJugador(JugadorDTO j) throws RemoteException;
	
	public List<JugadorDTO> listarJugadores() throws RemoteException;
	
	public void agregarObserver(Observer o) throws	RemoteException;
	///////////////////////////////////////////////////////////////////////////////
	
	public void accion(JugadorDTO jugador, String accion, boolean dueño) throws RemoteException;
	
	public void empezarPartida() throws RemoteException;
	
	public void cambiarPosicion(int posAnterior, int jugadorPos, int posicion) throws RemoteException;
	
	public void cambiarTurno(int jugPos) throws RemoteException;
	
	public void comprarPropiedad(JugadorDTO jugador, int posicion) throws RemoteException;


}
