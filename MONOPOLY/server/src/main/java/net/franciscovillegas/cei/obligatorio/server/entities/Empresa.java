package net.franciscovillegas.cei.obligatorio.server.entities;

public class Empresa  extends Casillero{

	private String Nombre;
	
	private int Valor;
	
	private int Multa;

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public int getValor() {
		return Valor;
	}

	public void setValor(int valor) {
		Valor = valor;
	}

	public int getMulta() {
		return Multa;
	}

	public void setMulta(int multa) {
		Multa = multa;
	}

	public Empresa(int pNro, String pTipo, Jugador pDueño, String nombre, int valor, int multa) {
		super(pNro, pTipo, pDueño);
		Nombre = nombre;
		Valor = valor;
		Multa = multa;
	}	
	
}
