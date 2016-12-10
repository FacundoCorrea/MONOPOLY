package net.franciscovillegas.cei.obligatorio.common.dto;

public class CartaDTO {

	private int Id;
	private String Tipo;
	private String Descripcion;
	
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

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

	private int Monto;
	private int Estado;

	public CartaDTO(int id,String tipo, String descripcion, int monto, int estado) {
		super();
		Id = id;
		Tipo = tipo;
		Descripcion = descripcion;
		Monto = monto;
		Estado = estado;
	}

}
