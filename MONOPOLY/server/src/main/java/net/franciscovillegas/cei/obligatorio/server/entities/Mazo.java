package net.franciscovillegas.cei.obligatorio.server.entities;

import java.util.List;

public class Mazo {
private List<Carta> cartas;

public List<Carta> getCartas() {
	return cartas;
}

public void setCartas(List<Carta> cartas) {
	this.cartas = cartas;
}

public Mazo(List<Carta> cartas) {

	this.cartas = cartas;
}

}
