package net.franciscovillegas.cei.obligatorio.server.Controllers;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import net.franciscovillegas.cei.obligatorio.common.TableroController;
import net.franciscovillegas.cei.obligatorio.common.dto.TableroDTO;
import net.franciscovillegas.cei.obligatorio.server.entities.Tablero;;

public class TableroControllerImpl extends UnicastRemoteObject implements TableroController{

	private static TableroControllerImpl instancia;


    public static TableroControllerImpl getinstance() throws RemoteException {
        if (instancia == null) {
            instancia = new TableroControllerImpl();
        }
        return instancia;
    }
    
    public TableroDTO crearTablero() throws RemoteException
    {
    	TableroDTO tablero = new TableroDTO(); 
    	// Aqui quisiera usar la entidad del server
    	return tablero;
    }
    
    private TableroControllerImpl() throws RemoteException {
		super();
	}
    
}
