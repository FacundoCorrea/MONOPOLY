package net.franciscovillegas.cei.obligatorio.common;

import java.rmi.Remote;
import java.rmi.RemoteException;

import net.franciscovillegas.cei.obligatorio.common.dto.Jugador;

public interface LoginController extends Remote {

	public Jugador autenticar(String username,String contraseña) throws RemoteException;
}
