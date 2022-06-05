/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebas;

import java.util.logging.Level;
import java.util.logging.Logger;


public class SincronizandoHilos {
    public static void main(String[] args) {
        HilosVarios hilo1=new HilosVarios();
        HilosVarios2 hilo2=new HilosVarios2(hilo1);
        
        hilo2.start();
        hilo1.start();

        System.out.println("Terminada las tareas");
    }
}



class HilosVarios2 extends Thread{
    Thread hilo;
    
    public HilosVarios2(Thread hilo){
        this.hilo=hilo;
    }
    
    
    @Override
    public void run() {
        try{
          hilo.join();  
        }
        catch(InterruptedException e){
            
        }
        
        for (int i=0;i<15;i++){
            try {
                System.out.println("Ejecutando Hilo"+this.getName());
                Thread.sleep(500);
            } catch (InterruptedException e) {
            }
        }
    }
    
}
