/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteproyecto;

import interfaces.IPersona;
import interfaces.IPersonaController;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jesus
 */
public class ClienteProyecto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            IPersonaController personaController = (IPersonaController) Naming.lookup("rmi://localhost/PersonaController");
                
            IPersona persona = personaController.newInstance();
            
            /*
            persona.setNombre("Antonio");
            persona.setApellidoPaterno("Estudillo");
            persona.setApellidoMaterno("Silva");
            persona.setRfc("1234567890");
            persona.setEmail("taeko@gmail.com");
            persona.setTelefono("92834823458");
            personaController.add(persona);
            */
            
            List<IPersona> lista = personaController.list();
                for(IPersona personaTemp: lista){
                    System.out.println(personaTemp.getString());
                }
            
          
                /*
                personaTres.setNombre("Onuki");
                personaTres.setTelefono("9211123429");
                int respuesta = personaController.update(personaTres);
                if (respuesta == IPersonaController.UPDATE_EXITOSO){
                    System.out.println("Actualizado con exito");
                }
                */
            /*persona.setId(4);
            int respuesta = personaController.delete(persona);
                System.out.println("Respuesta"+ respuesta);*/
            
            
        } catch (NotBoundException ex) {
            Logger.getLogger(ClienteProyecto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ClienteProyecto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(ClienteProyecto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
