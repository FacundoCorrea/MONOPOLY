package net.franciscovillegas.cei.obligatorio.common;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MensajeJugadorCambioCasilla extends Remote, Serializable{

	public void notify(String message) throws RemoteException;
}
