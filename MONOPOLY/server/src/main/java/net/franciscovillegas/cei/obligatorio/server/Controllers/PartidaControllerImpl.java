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
	private int[][] posiciones;
	
	private static PartidaControllerImpl instancia;
	
	public PartidaControllerImpl darPartidaInstance(){
		if(instancia == null){
			try {
				instancia = new PartidaControllerImpl();
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
		return instancia;
	}

    public PartidaControllerImpl() throws RemoteException {
		super();
		partida = new Partida();
		observadores = new ArrayList<Observer>();
	}

	public void empezarPartida() throws RemoteException {
		posiciones = new int[4][1];
		posiciones[0][0] = 0;
		posiciones[1][0] = 0;
		posiciones[2][0] = 0;
		posiciones[3][0] = 0;
		
		for(Observer o : observadores){
			try {
				o.empezarPartida(partida.getJugadoresEnJuego().get(0));
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
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


///////////////////////////////////////////////////////////////////////////////////////////////

	public void accion(Jugador jugador, String accion, boolean dueÃ) {
		// TODO Auto-generated method stub
		
	}

	public void cambiarPosicion(int posAnterior, int jugadorPos, int posicion) throws RemoteException {
		for(Observer o : observadores){
			try {
				o.cambiarPosicion(posAnterior, jugadorPos, posicion);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
		
	}

	public void cambiarTurno(int jugPos) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	public void comprarPropiedad(Jugador jugador, int posicion) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	public void accion(JugadorDTO jugador, String accion, boolean dueÃ) {
		// TODO Auto-generated method stub
		
	}

	public void comprarPropiedad(JugadorDTO jugador, int posicion)
			throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	
}
