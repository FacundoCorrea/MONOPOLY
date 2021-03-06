package net.franciscovillegas.cei.obligatorio.server;

import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import net.franciscovillegas.cei.obligatorio.common.*;
import net.franciscovillegas.cei.obligatorio.common.dto.JugadorDTO;
import net.franciscovillegas.cei.obligatorio.server.Controllers.*;
import net.franciscovillegas.cei.obligatorio.server.entities.LoginDominio;

public class ServerImpl implements Server {

	private List<Observer> observers;
	private PartidaController pc;
	
	
	@SuppressWarnings("deprecation")
	public ServerImpl() throws RemoteException {
		System.setProperty("java.security.policy","file://C:/java.policy");

		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new RMISecurityManager());
		}
		
		this.observers = new ArrayList<Observer>();
		pc = new PartidaControllerImpl();
	}
	
	public String sayHello() throws RemoteException {
		return "hola remoto";
	}
	
	public void addObserver(Observer observer) throws RemoteException {
		this.observers.add(observer);
	}

	public void sendMessage(String message) throws RemoteException {
		
		for(Observer o : this.observers) {
			o.notificar(message);
		}

	}
	
	public LoginController getLoginController() throws RemoteException
	{
		return LoginControllerImpl.getInstance();
	}
	
	
	public DadoController getDadoController() throws RemoteException
	{
		return DadoControllerImp.getInstance();
	}
	

	public PartidaController getPartidaController() throws RemoteException {
		return pc;
	}

	public List<Observer> getObservers() throws RemoteException {
		return observers;
	}

	public void setJugador(JugadorDTO jugador) throws RemoteException {
		for(Observer o : this.observers) {
			o.setJugador(jugador);
		}
		
	}

	public void pagarMulta(JugadorDTO dueño, int cantidad) throws RemoteException {
		for(Observer o : this.observers) {
			o.pagarMulta(dueño, cantidad);
		}
	}
	
}
