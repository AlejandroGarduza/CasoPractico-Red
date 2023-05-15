
package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IPersonaController extends Remote{
    
    IPersona newInstance() throws RemoteException;
    
    int add(IPersona persona) throws RemoteException;
    
    int update(IPersona persona) throws RemoteException;
    
    int delete(IPersona persona) throws RemoteException;
    
    int delete(int idPersona) throws RemoteException;
    
    IPersona findOne(int idPersona) throws RemoteException;
    
    List<IPersona> find(IPersona persona) throws RemoteException;
    
    List<IPersona> list() throws RemoteException;
    
    int ADD_EXITO = 1;
    int ID_DUPLICADO = 2;
    int ADD_SIN_EXITO = 3;   
    
    int UPDATE_EXITOSO = 1;
    int UPDATE_ID_DUPLICADO = 2;
    int UPDATE_ID_NULO = 3;
    int UPDATE_SIN_EXITO = 4;
    
    int DELETE_EXITO = 1;
    int DELETE_ID_INEXISTENTE = 2;
    int DELETE_ID_NULO = 3;
    int DELETE_SIN_EXITO = 4;
    
}
