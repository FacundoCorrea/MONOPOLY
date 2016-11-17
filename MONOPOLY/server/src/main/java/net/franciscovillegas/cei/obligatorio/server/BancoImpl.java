package net.franciscovillegas.cei.obligatorio.server;

import java.util.List;

import net.franciscovillegas.cei.obligatorio.server.entities.Jugador;
import net.franciscovillegas.cei.obligatorio.server.entities.Propiedad;

public class BancoImpl {

	private List<Jugador> RepartirPlata (List<Jugador> jugadores)
	{
		for(Jugador j : jugadores)
		{
			j.setDinero(1500);
		}
		return jugadores;
	}
	
	private void Hipotecar(Propiedad p , Jugador j)
	{
		j.setDinero( j.getDinero() + p.getValor());
		p.setHipoteca(true);
	}
}
