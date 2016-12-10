package net.franciscovillegas.cei.obligatorio.server.Controllers;
import net.franciscovillegas.cei.obligatorio.server.entities.Partida;
import net.franciscovillegas.cei.obligatorio.server.entities.Jugador;
import net.franciscovillegas.cei.obligatorio.server.entities.Tablero;
import net.franciscovillegas.cei.obligatorio.server.entities.Propiedad;
import net.franciscovillegas.cei.obligatorio.server.entities.Jugada;
import net.franciscovillegas.cei.obligatorio.server.entities.Accion;

public class AccionControllerImpl {
	
    private static AccionControllerImpl instancia;

    private AccionControllerImpl() {

    }

    public static AccionControllerImpl getinstance() {
        if (instancia == null) {
            instancia = new AccionControllerImpl();
        }
        return instancia;
    }
    
    public Jugada comprar(Accion miAccion) {

        try {

            Jugador miJugador = Partida.getInstance().getJugadordeTurno();
            Propiedad miPropiedad = (Propiedad) Tablero.getInstance().darCasillero(miJugador.getPosicion());
            if (miJugador.getDinero() - miPropiedad.getValor() >= 0) {
                miPropiedad.setDueño(miJugador);
                miJugador.setDinero(miJugador.getDinero() - miPropiedad.getValor());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return JugadaControllerImpl.construirJugada(miAccion);

    }

    public Jugada vender(Accion miAccion) {
        return JugadaControllerImpl.construirJugada(miAccion);

    }

    public Jugada pagarAlquiler(Accion miAccion) {

        try {

            Jugador miJugador = Partida.getInstance().getJugadordeTurno();
            Propiedad miTerreno = (Propiedad) Tablero.getInstance().darCasillero(miJugador.getPosicion());
            if (miJugador.getDinero() - miTerreno.getMulta() >= 0) {

                miJugador.setDinero(miJugador.getDinero() - miTerreno.getMulta());
                miTerreno.getDueño().setDinero(miTerreno.getDueño().getDinero() + miTerreno.getMulta());
                    
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return JugadaControllerImpl.construirJugada(miAccion);

    }

    public Jugada tirarDado(Accion miAccion) {

        try {

            Jugador miJugador = Partida.getInstance().getJugadordeTurno();

            if (Tablero.getInstance().darCasillero(miJugador.getPosicion()) instanceof Propiedad) {
                if (((Propiedad)Tablero.getInstance().darCasillero(miJugador.getPosicion())).getDueño() != miJugador) {
                    if (((Propiedad) Tablero.getInstance().darCasillero(miJugador.getPosicion())).getDueño() != null) {
                        miAccion.setTipo("pagarAlquiler");
                        miAccion.ejecutar();

                    }
                    

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return JugadaControllerImpl.construirJugada(miAccion);

    }

   /* public Jugada construir(Accion miAccion) {

        try {

            Jugador miJugador = Partida.getInstance().getJugadordeTurno();
            Propiedad miTerreno = (Propiedad) Tablero.getInstance().darCasillero(miJugador.getPosicion());
            if (miJugador.getDinero() - miTerreno.getValor() >= 0) {
                if (miTerreno.getCasas() <= 4) {
                    miTerreno.setCasas(miTerreno.getCasas() + 1);
                    miJugador.setDinero(miJugador.getDinero() - miTerreno.getBarrio().getValorCasa());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return ControllerJugada.construirJugada(miAccion);

    }*/



}
