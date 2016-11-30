package net.franciscovillegas.cei.obligatorio.server;

import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import net.franciscovillegas.cei.obligatorio.common.Observer;
import net.franciscovillegas.cei.obligatorio.common.Server;
import net.franciscovillegas.cei.obligatorio.common.LoginController;
import net.franciscovillegas.cei.obligatorio.common.DadoController;
import net.franciscovillegas.cei.obligatorio.server.Controllers.DadoControllerImp;
import net.franciscovillegas.cei.obligatorio.server.Controllers.LoginControllerImpl;
import net.franciscovillegas.cei.obligatorio.server.entities.LoginDominio;

public class ServerImpl implements Server {

	private List<Observer> observers;
	
	@SuppressWarnings("deprecation")
	public ServerImpl() {
		System.setProperty("java.security.policy","file://C:/java.policy");

		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new RMISecurityManager());
		}
		
		this.observers = new ArrayList<Observer>();
	}
	
	public String sayHello() throws RemoteException {
		return "hola remoto";
	}
	
	public void addObserver(Observer observer) throws RemoteException {
		this.observers.add(observer);
	}

	public void sendMessage(String message) throws RemoteException {
		
		// esta en common TODO hacer
	}
	
	public LoginController getLoginController() throws RemoteException
	{
		return LoginControllerImpl.getInstance();
	}
	
	
	public DadoController getDadoController() throws RemoteException
	{
		return DadoControllerImp.getInstance();
	}
	
}
