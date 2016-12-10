package net.franciscovillegas.cei.obligatorio.server.Controllers;
import java.util.ArrayList;
import java.util.List;

import net.franciscovillegas.cei.obligatorio.server.entities.*;

public class JugadaControllerImpl {

private static JugadaControllerImpl instancia;
    
    private JugadaControllerImpl(){}
    
    public static JugadaControllerImpl getInstance()
    {
        if(instancia == null)
        {
            instancia = new JugadaControllerImpl();
            
        }
        
        return instancia;
    }
    
    public static Jugada construirJugada(Accion accionRealizada)
    {
        Jugada miJugada = new Jugada();
        
        miJugada.setJugadorAnterior(Partida.getInstance().getJugadordeTurno());
        miJugada.setAccionRealizada(accionRealizada);
        
        if (accionRealizada.getTipo().equals("tirarDado") &&
                Tablero.getInstance().darCasillero(Partida.getInstance().getJugadordeTurno().getPosicion()) instanceof Propiedad)
        {
            miJugada.setAccionesDisponibles(accionesSobreTerreno());
            miJugada.setJugadorSiguiente(miJugada.getJugadorAnterior());
        }
        else if(accionRealizada.getTipo().equals("comprar"))
        {
            miJugada.setJugadorSiguiente(Partida.getInstance().getSiguienteJugador(miJugada.getJugadorAnterior()));  
            miJugada.setAccionesDisponibles(accionesPrimerTurno());
        }
        
        else if(accionRealizada.getTipo().equals("pagarAlquiler"))
        {
            miJugada.setJugadorSiguiente(Partida.getInstance().getSiguienteJugador(miJugada.getJugadorAnterior()));  
            miJugada.setAccionesDisponibles(accionesPrimerTurno());
        }
        
        else if(accionRealizada.getTipo().equals("construir"))
        {
            miJugada.setJugadorSiguiente(Partida.getInstance().getSiguienteJugador(miJugada.getJugadorAnterior()));  
            miJugada.setAccionesDisponibles(accionesPrimerTurno());
        }
        
         else if(accionRealizada.getTipo().equals("vender"))
        {
            miJugada.setJugadorSiguiente(Partida.getInstance().getSiguienteJugador(miJugada.getJugadorAnterior()));  
            miJugada.setAccionesDisponibles(accionesPrimerTurno());
        }
        
         else if(accionRealizada.getTipo().equals("sacarCartaEspecial"))
        {
            miJugada.setJugadorSiguiente(Partida.getInstance().getSiguienteJugador(miJugada.getJugadorAnterior()));  
            miJugada.setAccionesDisponibles(accionesPrimerTurno());
        }
        
        return miJugada;
    }
    
   
    
    private static List<Accion> accionesSobreTerreno()
    {
        List<Accion> retorno = new ArrayList<Accion>();
        
        retorno.add(new Accion("Comprar"));
        retorno.add(new Accion("Pasar"));
        return retorno;
    }
    
    private static List<Accion> accionesPrimerTurno()
    {
        List<Accion> retorno = new ArrayList<Accion>();
        
        retorno.add(new Accion("tirarDado"));
        return retorno;
    }

           
}
