package net.franciscovillegas.cei.obligatorio.server.entities;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cartas")
public class Carta {
	private String Tipo;
	private String Descripcion;
	private int Monto;
	private int Estado;

	public Carta(String tipo, String descripcion, int monto, int estado) {
		super();
		Tipo = tipo;
		Descripcion = descripcion;
		Monto = monto;
		Estado = estado;
	}

}
