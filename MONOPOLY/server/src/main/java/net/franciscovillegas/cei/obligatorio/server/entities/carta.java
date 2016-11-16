package net.franciscovillegas.cei.obligatorio.server.entities;

public class Carta {
	private String Tipo;
	private String Descripcion;
	private int Monto;
	private int Estado;
	public String getTipo() {
		return Tipo;
	}
	public void setTipo(String tipo) {
		Tipo = tipo;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	public int getMonto() {
		return Monto;
	}
	public void setMonto(int monto) {
		Monto = monto;
	}
	public int getEstado() {
		return Estado;
	}
	public void setEstado(int estado) {
		Estado = estado;
	}
	public Carta(String pTipo, String pDescripcion, int pMonto, int pEstado) {

		this.Tipo = pTipo;
		this.Descripcion = pDescripcion;
		this.Monto = pMonto;
		this.Estado = pEstado;
	}


}
