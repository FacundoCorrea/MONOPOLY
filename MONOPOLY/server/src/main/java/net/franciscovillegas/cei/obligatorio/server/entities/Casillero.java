package net.franciscovillegas.cei.obligatorio.server.entities;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

public class Casillero {

	private Integer Nro;
	
	private List<Jugador> JugadoresAqui;
	
	private String Tipo;
	
	private Jugador Dueño;

	public Integer getNro() {
		return Nro;
	}

	public void setNro(Integer nro) {
		this.Nro = nro;
	}

	public String getTipo() {
		return Tipo;
	}

	public void setTipo(String tipo) {
		this.Tipo = tipo;
	}

	public Jugador getDueño() {
		return Dueño;
	}

	public void setDueño(Jugador dueño) {
		Dueño = dueño;
	}
	
	public Casillero(int pNro,String pTipo,Jugador pDueño)
	{
		this.setNro(pNro);
		this.setTipo(pTipo);
		this.setDueño(pDueño);
	}
	
}
