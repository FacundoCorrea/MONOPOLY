package net.franciscovillegas.cei.obligatorio.common;

import java.rmi.Remote;
import java.rmi.RemoteException;

import net.franciscovillegas.cei.obligatorio.common.dto.JugadorDTO;

public interface LoginController extends Remote {

	public JugadorDTO autenticar(String username,String contraseña) throws RemoteException;
}
