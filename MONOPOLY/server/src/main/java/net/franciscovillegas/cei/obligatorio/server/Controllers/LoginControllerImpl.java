package net.franciscovillegas.cei.obligatorio.server.Controllers;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import net.franciscovillegas.cei.obligatorio.common.LoginController;
import net.franciscovillegas.cei.obligatorio.common.dto.JugadorDTO;

public class LoginControllerImpl extends UnicastRemoteObject implements LoginController {

	private static final long serialVersionUID = 1L;
	private static LoginController instance ;

	public static LoginController getInstance() throws RemoteException {
		if(instance == null) {
			instance = new LoginControllerImpl();
		}
		return instance;
	}

	private LoginControllerImpl() throws RemoteException {
		super();
	}

	public JugadorDTO autenticar(String username, String password) throws RemoteException {
		return new JugadorDTO(username,password);
	}

	
}
