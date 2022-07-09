/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaz;


import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMI extends Remote{
    
    /*
    Metodos remotos que sera utilizados en el servidor / cliente
    estableciendo una comunicacion entre ellos
    */
    
    public int producto(int n1, int n2) throws  RemoteException;
    
    public int CalcularFactorial(int factorial) throws  RemoteException;
     
    public int CalcularMayor(int n1, int n2) throws  RemoteException;
       
}
