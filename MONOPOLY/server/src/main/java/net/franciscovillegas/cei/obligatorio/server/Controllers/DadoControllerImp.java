package net.franciscovillegas.cei.obligatorio.server.Controllers;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Random;

import net.franciscovillegas.cei.obligatorio.common.DadoController;
import net.franciscovillegas.cei.obligatorio.common.dto.Jugador;

public class DadoControllerImp extends UnicastRemoteObject implements DadoController{

	private static DadoController instance = null;
	
	public static DadoController getInstance() throws RemoteException {
		if(instance == null) {
			instance = new DadoControllerImp();
		}
		return instance;
	}
	
	private DadoControllerImp() throws RemoteException {
		super();
	}
	
	public int tirarDado() throws RemoteException {
		Random numero = new Random();
		int numeroB = 0;
		numeroB = (numero.nextInt(6)+1);
				
		return numeroB;
	}
}
