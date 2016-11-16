package net.franciscovillegas.cei.obligatorio.server.entities;

public class Propiedad extends Casillero{

	private String Nombre;
	
	private String Color;
	
	private  int Valor;
	
	private int Multa;
	
	private int Estado;
	
	private boolean hipoteca;

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getColor() {
		return Color;
	}

	public void setColor(String color) {
		Color = color;
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

	public int getEstado() {
		return Estado;
	}

	public void setEstado(int estado) {
		Estado = estado;
	}

	public boolean isHipoteca() {
		return hipoteca;
	}

	public void setHipoteca(boolean hipoteca) {
		this.hipoteca = hipoteca;
	}

	public Propiedad(int pNro, String pTipo, Jugador pDueño, String nombre, String color, int valor, int multa,
			int estado, boolean hipoteca) {
		super(pNro, pTipo, pDueño);
		Nombre = nombre;
		Color = color;
		Valor = valor;
		Multa = multa;
		Estado = estado;
		this.hipoteca = hipoteca;
	}
	
	
}
