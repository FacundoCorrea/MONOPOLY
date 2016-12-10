package net.franciscovillegas.cei.obligatorio.gui;

import java.awt.EventQueue;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.Scanner;

import net.franciscovillegas.cei.obligatorio.common.Observer;
import net.franciscovillegas.cei.obligatorio.common.Server;
import net.franciscovillegas.cei.obligatorio.common.dto.JugadorDTO;

/**
 * Hello world!
 *
 */
public class App extends UnicastRemoteObject implements Observer {
	

	private static final long serialVersionUID = 1L;
	private Server server;
	private TableroIU window;
	private JugadorDTO dueñoDelTablero; // Si jugador en turno == a esta poronga entonces actual. este tablero
	public static void main(String[] args) throws RemoteException, NotBoundException {
		App app = new App();
	}
	
	public App() throws RemoteException, NotBoundException {
		Registry registry = LocateRegistry.getRegistry(1099);
		this.server = (Server) registry.lookup("server");
		server.addObserver(this);
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new TableroIU(server);
					window.setServer(server);
					window.setVisible();
					Login login = new Login(server);
					login.setVisible();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void sendMessage(String message) throws RemoteException {
		this.server.sendMessage(message);
	}
	


	public void mostrarJugadores() throws RemoteException {
		window.actualizar();
		
	}

	public void empezarPartida(JugadorDTO jugador) throws RemoteException {
		window.empezarPartida(this.dueñoDelTablero, jugador);
		window.setJugador(this.dueñoDelTablero);	
	}
///////////////////////////////////////////////////////////////////////////////////////////////////////
	public void actulizarTimer(int segundo) throws RemoteException {
		window.actualizarTimer(segundo);		
	}


	public void setJugador(JugadorDTO jugador) throws RemoteException {
		if(this.dueñoDelTablero == null){
			this.dueñoDelTablero = jugador;
		}	
	}

	public JugadorDTO getJugador() throws RemoteException {
		return this.dueñoDelTablero;
	}

	public void cambiarPosicion(int posAnterior, int jugadorPos, int posicion) throws RemoteException {
		window.cambiarPosicion(posAnterior,jugadorPos,posicion);
		
	}

	public void cambiarTurno(int posJugador, JugadorDTO jugador) throws RemoteException {
		window.cambiarTurno(posJugador, this.dueñoDelTablero, jugador);
		
	}


	public void pagarMulta(JugadorDTO dueño , int cantidad) {
		window.pagarMulta(dueño, cantidad);
		
	}
	
	public void comprarPropiedad(JugadorDTO jugador, int posicion) throws RemoteException {
		window.comprarPropiedad(jugador, posicion);
		
	}
	public void acciones(JugadorDTO jugador, java.util.List<String> acciones) throws RemoteException {
		window.mostrarOpciones(jugador, acciones);

		
	}
	
	
	
	



}
