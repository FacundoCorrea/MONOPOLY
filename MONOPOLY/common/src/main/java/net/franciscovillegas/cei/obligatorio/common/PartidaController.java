package net.franciscovillegas.cei.obligatorio.common;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import net.franciscovillegas.cei.obligatorio.common.dto.JugadorDTO;

public interface PartidaController extends Remote {

	public void moverJugador() throws RemoteException;
	
	public void agregarJugador(JugadorDTO j) throws RemoteException;
	
	public List<JugadorDTO> listarJugadores() throws RemoteException;
	
	public void agregarObserver(Observer o) throws	RemoteException;

}
