package net.franciscovillegas.cei.obligatorio.common;

import java.rmi.Remote;
import java.rmi.RemoteException;

import net.franciscovillegas.cei.obligatorio.common.dto.TableroDTO;


public interface TableroController extends Remote{
	
	public TableroDTO crearTablero() throws RemoteException;
}
