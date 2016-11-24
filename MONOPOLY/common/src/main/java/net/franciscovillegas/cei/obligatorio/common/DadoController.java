package net.franciscovillegas.cei.obligatorio.common;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface DadoController extends Remote{
	
	public int tirarDado() throws RemoteException;

}
