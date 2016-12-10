package net.franciscovillegas.cei.obligatorio.common;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import net.franciscovillegas.cei.obligatorio.common.dto.JugadorDTO;

public interface Server extends Remote {

	public String sayHello() throws RemoteException;

	public void sendMessage(String message) throws RemoteException;

	public void addObserver(Observer observer) throws RemoteException;
	
	public List<Observer> getObservers() throws RemoteException;
	
	public LoginController getLoginController() throws RemoteException;
	
	public DadoController getDadoController() throws RemoteException;
	
	public PartidaController getPartidaController() throws RemoteException;
	
	public void setJugador(JugadorDTO jugador) throws RemoteException;
	
	public void pagarMulta(JugadorDTO dueño, int cantidad) throws RemoteException;


}
