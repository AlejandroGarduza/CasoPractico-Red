/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorproyecto;

import interfaces.IPersonaController;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jesus
 */
public class ServidorProyecto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DBManager dBManager = new DBManager();
        
        try {
            LocateRegistry.createRegistry(1099);
            IPersonaController personaController = new PersonaController();
            Naming.rebind("rmi://localhost/PersonaController", personaController);
            System.out.println("Escuchando...");
        } catch (RemoteException ex) {
            Logger.getLogger(ServidorProyecto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ServidorProyecto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
