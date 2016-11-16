package net.franciscovillegas.cei.obligatorio.server.entities;

public class Banco {

	private int Dinero;

	public int getDinero() {
		return Dinero;
	}

	public void setDinero(int dinero) {
		Dinero = dinero;
	}

	public Banco(int dinero) {
		super();
		Dinero = dinero;
	}
}
