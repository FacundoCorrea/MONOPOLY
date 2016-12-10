package net.franciscovillegas.cei.obligatorio.server.entities;
import net.franciscovillegas.cei.obligatorio.server.Controllers.*;

public class Accion {
	
	private String tipo;

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public Accion(String tipo) {
        this.tipo = tipo;
    }

	public Accion() {
    }

	
	public Jugada Acciones()
    {
        if (tipo.equals("comprar"))
        {
            
           return AccionControllerImpl.getinstance().comprar(this);

            
        }
        
        /*if (tipo.equals("construir"))
        {
            
           return AccionControllerImpl.getinstance().construir(this);

            
        }*/
        
        if (tipo.equals("pagarAlquiler"))
        {
            
           return AccionControllerImpl.getinstance().pagarAlquiler(this);

            
        }
        
        if (tipo.equals("vender"))
        {
            
           return AccionControllerImpl.getinstance().vender(this);

            
        }
        if (tipo.equals("tirarDado"))
        {
            
           return AccionControllerImpl.getinstance().tirarDado(this);

            
        }
         if (tipo.equals("sacarCartaEspecial"))
        {
            
           return AccionControllerImpl.getinstance().tirarDado(this);

            
        }
        
        return null;
    }
	public Jugada ejecutar()
    {
        if (tipo.equals("comprar"))
        {
            
           return AccionControllerImpl.getinstance().comprar(this);

            
        }
        
       /* if (tipo.equals("construir"))
        {
            
           return AccionControllerImpl.getinstance().construir(this);

            
        }*/
        
        if (tipo.equals("pagarAlquiler"))
        {
            
           return AccionControllerImpl.getinstance().pagarAlquiler(this);

            
        }
        
        if (tipo.equals("vender"))
        {
            
           return AccionControllerImpl.getinstance().vender(this);

            
        }
        if (tipo.equals("tirarDado"))
        {
            
           return AccionControllerImpl.getinstance().tirarDado(this);

            
        }
         if (tipo.equals("sacarCartaEspecial"))
        {
            
           return AccionControllerImpl.getinstance().tirarDado(this);

            
        }
        
        return null;
    }


}
