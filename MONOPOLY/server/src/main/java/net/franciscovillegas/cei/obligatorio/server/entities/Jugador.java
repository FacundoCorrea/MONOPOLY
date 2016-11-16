package net.franciscovillegas.cei.obligatorio.server.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "jugadores")
public class Jugador implements Serializable{

	private int id;
	private int ganadas;
	private int perdidas;
	private int cartaCarcel;
	private int posicion;
	private String usuario;
	private String contraseña;
	private int dinero;
	public Jugador(int id, int ganadas, int perdidas, int cartaCarcel, int posicion, String usuario, String contraseña,
			int dinero) {
		super();
		this.id = id;
		this.ganadas = ganadas;
		this.perdidas = perdidas;
		this.cartaCarcel = cartaCarcel;
		this.posicion = posicion;
		this.usuario = usuario;
		this.contraseña = contraseña;
		this.dinero = dinero;
	}
}