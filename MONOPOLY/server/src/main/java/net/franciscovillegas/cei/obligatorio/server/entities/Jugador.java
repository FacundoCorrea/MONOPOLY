package net.franciscovillegas.cei.obligatorio.server.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jugadores")
public class Jugador implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	private int dinero;
	private int ganadas;
	private int perdidas;
	private int cartaCarcel;
	private int posicion;
	private String usuario;
	private String contraseña;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getGanadas() {
		return ganadas;
	}

	public void setGanadas(int ganadas) {
		this.ganadas = ganadas;
	}

	public int getPerdidas() {
		return perdidas;
	}

	public void setPerdidas(int perdidas) {
		this.perdidas = perdidas;
	}

	public int getCartaCarcel() {
		return cartaCarcel;
	}

	public void setCartaCarcel(int cartaCarcel) {
		this.cartaCarcel = cartaCarcel;
	}

	public int getPosicion() {
		return posicion;
	}

	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public int getDinero() {
		return dinero;
	}

	public void setDinero(int dinero) {
		this.dinero = dinero;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	
	public Jugador(int id, int ganadas, int perdidas, int cartaCarcel, int posicion, String usuario, String contraseña,
			int dinero) {

		this.id = id;
		this.ganadas = ganadas;
		this.perdidas = perdidas;
		this.cartaCarcel = cartaCarcel;
		this.posicion = posicion;
		this.usuario = usuario;
		this.contraseña = contraseña;
		this.dinero = dinero;
	}
	
	public Jugador(){}
}