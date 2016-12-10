package net.franciscovillegas.cei.obligatorio.gui;

import java.awt.EventQueue;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

import net.franciscovillegas.cei.obligatorio.common.Observer;
import net.franciscovillegas.cei.obligatorio.common.Server;
import net.franciscovillegas.cei.obligatorio.common.dto.JugadorDTO;

/**
 * Hello world!
 *
 */
public class App extends UnicastRemoteObject implements Observer {
	
	private Server server;
	private TableroIU window;
	private JugadorDTO dueñoDelTablero; // Si jugador en turno == a esta poronga entonces actual. este tablero
	
	public App() throws RemoteException, NotBoundException {
		System.out.println(System.currentTimeMillis());
		System.setProperty("java.security.policy","file:///java.policy");
		System.out.println("Hello World!");
		Registry registry = LocateRegistry.getRegistry(1099);
		this.server = (Server) registry.lookup("server");
		String response = server.sayHello();
		System.out.println("response: " + response);
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
	
	public static void main(String[] args) throws RemoteException, NotBoundException {
		App app = new App();
	}

	public void mostrarJugadores() throws RemoteException {
		window.actualizar();
		
	}

}
