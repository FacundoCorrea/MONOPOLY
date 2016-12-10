package net.franciscovillegas.cei.obligatorio.common;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface Server extends Remote {

	public String sayHello() throws RemoteException;

	public void sendMessage(String message) throws RemoteException;

	public void addObserver(Observer observer) throws RemoteException;
	
	public List<Observer> getObservers() throws RemoteException;
	
	public LoginController getLoginController() throws RemoteException;
	
	public DadoController getDadoController() throws RemoteException;
	
	public PartidaController getPartidaController() throws RemoteException;

}
