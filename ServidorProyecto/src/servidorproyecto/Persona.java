/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorproyecto;

import interfaces.IPersona;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author jesus
 */
public class Persona extends UnicastRemoteObject implements IPersona{
    
    private int id;
    private String nombre;
    private String email;
    private String telefono;
    private String rfc;
    private String apellidoPaterno;
    private String apellidoMaterno;

    public Persona() throws RemoteException{}
    
    public Persona(int id, String nombre, String email, String telefono, String rfc, String apellidoPaterno, String apellidoMaterno) throws RemoteException {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.rfc = rfc;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        
                
    }

    public int getId() throws RemoteException{
        return id;
    }

    public void setId(int id) throws RemoteException{
        this.id = id;
    }

    public String getNombre() throws RemoteException{
        return nombre;
    }

    public void setNombre(String nombre) throws RemoteException{
        this.nombre = nombre;
    }

    public String getEmail() throws RemoteException{
        return email;
    }

    public void setEmail(String email) throws RemoteException{
        this.email = email;
    }

    public String getTelefono() throws RemoteException{
        return telefono;
    }

    public void setTelefono(String telefono) throws RemoteException{
        this.telefono = telefono;
    }

    @Override
    public String getString() throws RemoteException {

        return String.format("Id: %d, Nombre: %s, Email: %s, Telefono: %s", getId(), getNombre(), getEmail(), getTelefono());
    }
    
    public static IPersona fromMap(Map<String, Object> map ) throws RemoteException{
        IPersona persona = new Persona();
        
        if(map.containsKey("IdPersona"))
                persona.setId( (Integer) map.get("IdPersona"));
            
            if(map.containsKey("Nombre"))
                persona.setNombre( (String) map.get("Nombre"));
            
            if(map.containsKey("Telefono") && map.get("Telefono") != null)
                persona.setTelefono((String) map.get("Telefono"));
            
            if(map.containsKey("Email"))
                persona.setEmail((String) map.get("Email"));
            
            return persona;
    }

    public static Map<String, Object> toMap(IPersona persona) throws RemoteException{
        Map<String, Object> datos = new HashMap<>();
        if(persona.getId() != 0){
        datos.put("IdPersona", persona.getId());
        }
        if(persona.getNombre()!= null){
        datos.put("Nombre", persona.getNombre());
        }
        if(persona.getTelefono()!= null){
        datos.put("Telefono", persona.getTelefono());
        }
        if(persona.getEmail()!= null){
        datos.put("Email", persona.getEmail());
        }
        
        return datos;
    }

    @Override
    public String getRfc() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setRfc() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getApellidoPaterno() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setApellidoPaterno() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getApellidoMaterno() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setApellidoMaterno() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    

    
    
}
