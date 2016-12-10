package net.franciscovillegas.cei.obligatorio.server.entities;
import net.franciscovillegas.cei.obligatorio.common.dto.*;

import java.util.ArrayList;
import java.util.List;

public class Partida {

	private List<JugadorDTO> Jugadores;
	
	private List<JugadorDTO> JugadoresEnJuego;
	
	private JugadorDTO JugadordeTurno;
	
	private Tablero tablero;
	
	private Mazo Mazo;
	
	private static Partida instancia;
	
	public Partida(){
		JugadoresEnJuego = new ArrayList<JugadorDTO>();
	}
	
	
	public JugadorDTO getJugadordeTurno() {
		return JugadordeTurno;
	}


	public void setJugadordeTurno(JugadorDTO jugadordeTurno) {
		JugadordeTurno = jugadordeTurno;
	}


	public static Partida getInstance() {
        if (instancia == null) {
            instancia = new Partida();

        }
        return instancia;
    }

	public JugadorDTO getSiguienteJugador(JugadorDTO miJugador) {

        for (int i = 0; i < Jugadores.size() - 1; i++) {
            if (Jugadores.get(i).equals(miJugador))
            {
                return Jugadores.get(i+1);
            }
        }
        return Jugadores.get(0);
        
    }
	
	public List<JugadorDTO> getJugadores() {
		return Jugadores;
	}

	public void setJugadores(List<JugadorDTO> jugadores) {
		Jugadores = jugadores;
	}

	public List<JugadorDTO> getJugadoresEnJuego() {
		return JugadoresEnJuego;
	}

	public void setJugadoresEnJuego(List<JugadorDTO> jugadoresEnJuego) {
		JugadoresEnJuego = jugadoresEnJuego;
	}

	public Tablero getTablero() {
		return tablero;
	}

	public void setTablero(Tablero pTablero) {
		tablero = pTablero;
	}

	public Mazo getMazo() {
		return Mazo;
	}

	public void setMazo(Mazo mazo) {
		Mazo = mazo;
	}
	
	public void agregarJugador(JugadorDTO j)
	{
		if(JugadoresEnJuego.size() < 4)
		{
		JugadoresEnJuego.add(j);
		}
	}

	public Partida(List<JugadorDTO> jugadores, List<JugadorDTO> jugadoresEnJuego,Tablero pTablero,Mazo mazo) {
		super();
		Jugadores = jugadores;
		JugadoresEnJuego = jugadoresEnJuego;
		tablero = pTablero;
		Mazo = mazo;
	}
	

	
	
	
}
