/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProductorConsumidor;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author eduardo
 */
public class Productor extends Thread{

    private List<String> mensajes =
            new ArrayList<String>();
    
    private final int MAX=7;
    
    @Override
    public void run() {
        try {
            while (true) {                
                putMessage();
                sleep(1000);
            }
        } catch (Exception e) {
            System.err.println("Error");
        }
    }
    
    private synchronized void putMessage(){
        try {
            while (mensajes.size()==MAX) {                
                wait();
            }
            mensajes.add(
            new java.util.Date().toString());
            notify();
        } catch (Exception e) {
            System.err.println("Ocurrio un error");
        }
    }
    
    public synchronized String getMessage(){
        try {
            notify();
            while(mensajes.size()==0){
                wait();
            } 
            String msj=(String)mensajes.get(0);
            mensajes.remove(0);
            return msj;
        } catch (Exception e) {
            return "Error";
        }
    }
}
      
