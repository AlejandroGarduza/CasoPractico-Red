
package servidorproyecto;

import interfaces.IPersona;
import interfaces.IPersonaController;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersonaController extends UnicastRemoteObject implements IPersonaController{

    private DBManager dbManager; 
    
    private final String TABLE = "Personas";
    
    public PersonaController() throws RemoteException {
        dbManager = new DBManager();
    }

    @Override
    public int add(IPersona persona) throws RemoteException {
        
       IPersona personaEncontrado = findOne(persona.getId());
        boolean existe = personaEncontrado.getId() != 0;
        
        if(existe){
            return ID_DUPLICADO;
        }
        
        Map<String, Object> datos = Persona.toMap(persona); 
        int respuesta = dbManager.insertar(TABLE, datos);
        
        return (respuesta > 0) ? ADD_EXITO : ADD_SIN_EXITO ;
    }

    @Override
    public IPersona newInstance() throws RemoteException {
        return new Persona();
    }


    @Override
    public int update(IPersona persona) throws RemoteException {
        if(persona.getId() == 0){
            return UPDATE_ID_NULO;
        }
        
        IPersona personaEncontrado = findOne(persona.getId());
        if(personaEncontrado.getId() == 0){
            return UPDATE_ID_INEXISTENTE;
        }
        
        
        Map<String, Object> datos = Persona.toMap(persona);
        Map<String, Object> where = new HashMap<>();
        where.put("iDPersona", persona.getId());
        int respuesta = dbManager.actualizar(TABLE, datos, where);
         
        if(respuesta > 0){
            return UPDATE_EXITOSO;
        }else{
            return UPDATE_SIN_EXITO;
        }
        
    }

    @Override
    public int delete(IPersona persona) throws RemoteException {
            IPersona personaTemp = findOne(persona.getId());
        if(personaTemp.getId() == 0){
            return DELETE_ID_INEXISTENTE;
        }
        
        Map<String, Object> where = new HashMap<>();
        where.put("IdPersona", persona.getId());
        int respuesta =dbManager.eliminar(TABLE,where);
        if(respuesta == 0){
            return DELETE_SIN_EXITO;
        }else{
            return DELETE_EXITO;
        }
    }

    @Override
    public IPersona findOne(int idPersona) throws RemoteException {
        
            
            Map<String, Object> where = new HashMap<>();
            where.put("IdPersona", idPersona);
            Map<String, Object> registro =  dbManager.buscarUno(TABLE, where);
            IPersona persona = Persona.fromMap(registro);
            return persona;
        
    }

    @Override
    public List<IPersona> list() throws RemoteException {
        List<IPersona> listaPersonas = new ArrayList<>();
        
        List<Map<String, Object>> registros = dbManager.listar(TABLE);
        for(Map<String, Object> registro:registros){
            IPersona persona =  Persona.fromMap(registro);
            
            listaPersonas.add(persona);
            
        }
        return listaPersonas;
    }

    @Override
    public List<IPersona> find(IPersona persona) throws RemoteException {
        List<IPersona> listaPersonas = new ArrayList<>();
        Map<String, Object> where = Persona.toMap(persona);
        List<Map<String, Object>> registros = dbManager.listar(TABLE,where);
        for(Map<String, Object> registro:registros){
            IPersona personaTemp =  Persona.fromMap(registro);
            
            listaPersonas.add(personaTemp);
            
        }
        return listaPersonas;
    }

    @Override
    public int delete(int idPersona) throws RemoteException {
        IPersona personaTemp = findOne(idPersona);
        if(personaTemp.getId() == 0){
            return DELETE_ID_INEXISTENTE;
        }
        
        Map<String, Object> where = new HashMap<>();
        where.put("IdPersona", idPersona);
        int respuesta =dbManager.eliminar(TABLE,where);
        if(respuesta == 0){
            return DELETE_SIN_EXITO;
        }else{
            return DELETE_EXITO;
        }
    }
   

    
}

