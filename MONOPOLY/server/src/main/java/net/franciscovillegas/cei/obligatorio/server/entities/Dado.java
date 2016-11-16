package net.franciscovillegas.cei.obligatorio.server.entities;

public class Dado {
	private int Valor1;
	private int Valor2;
	public int getValor1() {
		return Valor1;
	}
	public void setValor1(int valor1) {
		Valor1 = valor1;
	}
	public int getValor2() {
		return Valor2;
	}
	public void setValor2(int valor2) {
		Valor2 = valor2;
	}
	public Dado(int valor1, int valor2) {

		Valor1 = valor1;
		Valor2 = valor2;
	}
	
}
