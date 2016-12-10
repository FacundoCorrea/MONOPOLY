package net.franciscovillegas.cei.obligatorio.server.Controllers;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import net.franciscovillegas.cei.obligatorio.common.LoginController;
import net.franciscovillegas.cei.obligatorio.common.dto.JugadorDTO;
import net.franciscovillegas.cei.obligatorio.server.entities.Partida;

public class LoginControllerImpl extends UnicastRemoteObject implements LoginController {

	private static final long serialVersionUID = 1L;
	private static LoginController instance ;
	private Partida p;
	private ArrayList<JugadorDTO> jugadores = new ArrayList<JugadorDTO>();

	public static LoginController getInstance() throws RemoteException {
		if(instance == null) {
			instance = new LoginControllerImpl();
		}
		return instance;
	}

	private LoginControllerImpl() throws RemoteException {
		super();
	}
	
	private void cargarJugadores()
	{
		JugadorDTO J1 = new JugadorDTO("Facundo","123",1000,2,1); 
		JugadorDTO J2 = new JugadorDTO("Emerson", "123",1000,3,1);
		JugadorDTO J3 = new JugadorDTO("Guzman", "123",1000,2,1);
		JugadorDTO J4 = new JugadorDTO("Franco", "123",1000,1,1);
		jugadores.add(J1);
		jugadores.add(J2);
		jugadores.add(J3);
		jugadores.add(J4);
	}

	public JugadorDTO autenticar(String username, String password) throws RemoteException {
		cargarJugadores();
		JugadorDTO j = null; 
		for(JugadorDTO f : jugadores)
		{
			if(f.getNombre().equals(username) && f.getPassword().equals(password))
			{
				j = f;
			}
		}
		return j;
	}

	
}
