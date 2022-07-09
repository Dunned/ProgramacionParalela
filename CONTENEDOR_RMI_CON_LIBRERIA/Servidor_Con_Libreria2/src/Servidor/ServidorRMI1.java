/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servidor;

import Interfaz.RMI;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;


public class ServidorRMI1 extends UnicastRemoteObject implements RMI{
    
    public ServidorRMI1() throws RemoteException{
        
    }
    
    public static void main(String[] args) {
        try {
            /*
            Servidor se encuentra a la escucha de la peticion del cliente , para que este cliente acceda a los metodos
            remotos registrados por el servidor
            */
                  
            Registry registro=LocateRegistry.createRegistry(7777);
            registro.rebind("RemotoRMI", new ServidorRMI1());
            System.out.println("Servidor Activo !!!");
            
        } catch (Exception e) {
            
            System.out.println("Ocurrio una excepcion: "+e.getMessage());
            
        }
    }

    @Override
    public int producto(int n1, int n2) throws RemoteException {
        return (n1 * n2);
    }

    @Override
    public int CalcularFactorial(int factorial) throws RemoteException {
       int acumfact = 1;
       
       for(int j=factorial; j>0; j--){
           acumfact = acumfact * j;
       }
       
       return acumfact;
    }

    @Override
    public int CalcularMayor(int n1, int n2) throws RemoteException {
        int mayor = 0;
        
        if (n1 > n2){
            mayor  = n1;
        }else{
            mayor = n2;
        }
        return mayor;
    }
    
    
    
}
