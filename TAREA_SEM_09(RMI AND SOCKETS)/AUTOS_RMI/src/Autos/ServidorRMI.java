/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package Autos;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ServidorRMI extends UnicastRemoteObject implements RMI{
    
    public static Autos window;
    
    public ServidorRMI() throws RemoteException {
        
    }
    
    public static void main(String[] args) {
        try {
            Registry registro = LocateRegistry.createRegistry(7777);
            registro.rebind("RemoteRMI", new ServidorRMI());
            System.out.println("Servidor activo!!");
            window = new Autos();
            window.JFrame.setVisible(true);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    @Override
    public int ejecutar() throws RemoteException{
        window.iniciarCarrera();
        while(true){
            System.out.println("Corriendo...");
            if (window.Ganador) {
                return window.Auto_ganador;
            }
        }
        
    }

}
