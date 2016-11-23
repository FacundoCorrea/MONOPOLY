package net.franciscovillegas.cei.obligatorio.server.entities;

import java.util.List;

public class Tablero {

	private Casillero[] casilleros = new Casillero[16];


	public Tablero() {
		casilleros[0] = new Otra(1, "Inicio",null, "Inicio", "Inicio de la partida", 200);
		casilleros[1] = new Propiedad(2, "Propiedad",null,"Maldonado","Verde",200,-20,0,false);
		casilleros[2] = new Otra(3,"Suerte",null,"Suerte","Suerte",0);
		casilleros[3] = new Propiedad(4,"Propiedad",null,"Montevideo","Verde",300,-30,0,false);
		casilleros[4] = new Otra(5,"Vaya_Carcel",null,"Vaya a la Carcel","Vaya a la Carcel",0);
		casilleros[5] = new Propiedad(6,"Propiedad",null,"New York","Azul",500,-50,0,false);
		casilleros[6] = new Empresa(7,"Empresa",null,"Agua",400,-40);
		casilleros[7] = new Propiedad(8,"Propiedad",null,"Dallas","Azul",500,-50,0,false);
		casilleros[8] = new Otra(9, "Parada_Libre",null, "parada_Libre", "No pasa nada", 0);
		casilleros[9] = new Propiedad(10,"Propiedad",null,"Moscu","Rojo",300,-30,0,false);
		casilleros[10] = new Otra(11,"Destino",null,"Destino","Destino",0);
		casilleros[11] = new Propiedad(12,"Propiedad",null,"San Petersburgo","Rojo",200,-20,0,false);
		casilleros[12] = new Otra(13,"Carcel",null,"Carcel","Pierde turnos",0);
		casilleros[13] = new Propiedad(14,"Propiedad",null,"Sao Pablo","Violeta",100,-10,0,false);
		casilleros[14] = new Empresa(15,"Empresa",null,"Luz",400,-40);
		casilleros[15] = new Propiedad(16,"Propiedad",null,"Brasilia","Violeta",100,-10,0,false);
	}
	
	
}
