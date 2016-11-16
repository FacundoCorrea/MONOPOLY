package net.franciscovillegas.cei.obligatorio.server.entities;

public class Carta {
	private String tipo;
	private String descripcion;
	private int monto;
	private int estado;
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String Tipo) {
		tipo = Tipo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String Descripcion) {
		descripcion = Descripcion;
	}
	public int getMonto() {
		return monto;
	}
	public void setMonto(int Monto) {
		monto = Monto;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int Estado) {
		estado = Estado;
	}
	public Carta(String pTipo, String pDescripcion, int pMonto, int pEstado) {

		this.tipo = pTipo;
		this.descripcion = pDescripcion;
		this.monto = pMonto;
		this.estado = pEstado;
	}


}
