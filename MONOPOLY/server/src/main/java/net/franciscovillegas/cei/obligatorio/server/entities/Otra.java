package net.franciscovillegas.cei.obligatorio.server.entities;

public class Otra extends Casillero {

	private String Nombre;
	
	private String Descripcion;
	
	private int Multa;

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public int getMulta() {
		return Multa;
	}

	public void setMulta(int multa) {
		Multa = multa;
	}

	public Otra(int pNro, String pTipo, Jugador pDueño, String nombre, String descripcion, int multa) {
		super(pNro, pTipo, pDueño);
		Nombre = nombre;
		Descripcion = descripcion;
		Multa = multa;
	}
}
