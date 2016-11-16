package net.franciscovillegas.cei.obligatorio.server.entities;

public class carta {
	private String Tipo;
	private String Descripcion;
	private int Monto;
	private int Estado;
		public carta(String tipo, String descripcion, int monto, int estado) {
			super();
			Tipo = tipo;
			Descripcion = descripcion;
			Monto = monto;
			Estado = estado;
		}

}
