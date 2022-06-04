/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author eduardo
 */
public class HilosModel implements Runnable{
    
    private String mensaje=null;

    public HilosModel(String mensaje) {
        this.mensaje=mensaje;
    }
    
    

    @Override
    public void run() {
        //int i=0;
        try {
            while (true) {                
                //i++;
                System.out.println("\nSe esta ejecutando : "+this.mensaje);
                Thread.sleep((int)(Math.random()*10000));
            }
        } catch (Exception e) {
        }
        
    }
    
}
