package net.franciscovillegas.cei.obligatorio.server.Controllers;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import net.franciscovillegas.cei.obligatorio.server.entities.*;
import net.franciscovillegas.cei.obligatorio.common.*;
import net.franciscovillegas.cei.obligatorio.common.dto.JugadorDTO;

public class PartidaControllerImpl extends UnicastRemoteObject implements PartidaController, Serializable{

	private ArrayList<Observer> observadores ;
	private Partida partida;
	private int[][] posiciones;
	private boolean timerCorriendo = false;
	private Timer timer = null;

	
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
		actulizarUI();
		partidaCountdown();
	}

	public List<JugadorDTO> listarJugadores() throws RemoteException {
		
		return partida.getJugadoresEnJuego();
	}

	public void agregarObserver(Observer o) throws RemoteException {
		if(!observadores.contains(o))
		{
		observadores.add(o);  
		actulizarUI();
		}
		
	}

	public void accion(JugadorDTO jugador, String accion, boolean dueño) throws RemoteException {
		List<String> acciones = new ArrayList<String>();
		
		if(accion.equals("INICIO")){
			acciones.add("PASAR");
			acciones.add("RECOMPENSA");	
		}
		else if(accion.equals("SERVICIO") || accion.equals("PROPIEDAD")){
			if(dueño){
				acciones.add("MULTA");
			}
			else{
				acciones.add("COMPRAR");
				acciones.add("PASAR");
			}
		}
		else if(accion.equals("CARCEL") || accion.equals("LIBRE")){
			acciones.add("PASAR");
		}
		else if(accion.equals("DESTINO")){
			acciones.add("DESTINO");
		}
		else if(accion.equals("POLICIA")){
			acciones.add("CARCEL");
		}
		else if(accion.equals("SUERTE")){
			acciones.add("SUERTE");
		}
		
		for(Observer o : observadores){
			try {
				o.acciones(jugador, acciones);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
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
		List<JugadorDTO> jugadores = partida.getJugadoresEnJuego();
		System.out.println("SIZE=" + jugadores.size());
		int pos = jugPos+1;
		
		if(jugadores.size() <= pos){
			pos = 0;
		}
		
		for(Observer o : observadores){
			try {
				o.cambiarTurno(pos, jugadores.get(pos));
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
	}


	public void comprarPropiedad(JugadorDTO jugador, int posicion) throws RemoteException {
		for(Observer o : observadores){
			try {
				o.comprarPropiedad(jugador, posicion);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void partidaCountdown() throws RemoteException{
		if(listarJugadores().size() >= 2){
			if(timerCorriendo && timer != null){
				timer.cancel();
			}
			
			timer = new Timer();
			
		    TimerTask task = new TimerTask(){
		        private int i = 10;
		        public void run(){
		            if (i >= 0) {
		            	actualizarTimer(i);
		            	i--;
		            }
		            else{
		            	timerCorriendo = false;
		            	timer.cancel();
		            	timer.purge();
		            	try {
							empezarPartida();
						} catch (RemoteException e) {
							e.printStackTrace();
						}
		            }
		        }
		    };
		    timer.scheduleAtFixedRate(task, 0, 1000);
		    timerCorriendo = true;
		}
	}
	
	private void actulizarUI(){
		for(Observer o : observadores){
			try {
				o.notificar("Notificar");
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void actualizarTimer(int segundo){
		for(Observer o : observadores){
			try {
				o.actualizarTimer(segundo);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
	}
	



	
}
