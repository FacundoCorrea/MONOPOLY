package net.franciscovillegas.cei.obligatorio.server.Controllers;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import net.franciscovillegas.cei.obligatorio.server.entities.*;
import net.franciscovillegas.cei.obligatorio.common.*;
import net.franciscovillegas.cei.obligatorio.common.dto.JugadorDTO;

public class PartidaControllerImpl extends UnicastRemoteObject implements PartidaController, Serializable{

	private ArrayList<Observer> observadores ;
	private Partida partida;
	

    public PartidaControllerImpl() throws RemoteException {
		super();
		partida = new Partida();
		observadores = new ArrayList<Observer>();
	}

	public Jugada ejecutarAccion(Accion miAccion)
    {
        return miAccion.ejecutar();
        
    }

	public void moverJugador() throws RemoteException {
		
	}

	public void agregarJugador(JugadorDTO j) throws RemoteException {
		partida.agregarJugador(j);
		actualizar();
	}
	
	private void actualizar() throws RemoteException
	{
		for(Observer o : observadores)
		{
			o.mostrarJugadores();
		}
	}

	public List<JugadorDTO> listarJugadores() throws RemoteException {
		
		return partida.getJugadoresEnJuego();
	}

	public void agregarObserver(Observer o) throws RemoteException {
		observadores.add(o);
		
	}
	
	
}
