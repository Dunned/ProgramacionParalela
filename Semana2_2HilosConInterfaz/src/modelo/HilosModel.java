/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import javax.swing.JTextArea;

/**
 *
 * @author eduardo
 */
public class HilosModel implements Runnable{
    
    private String mensaje=null;
    JTextArea area;

    public HilosModel(String mensaje,JTextArea area) {
        this.mensaje=mensaje;
        this.area=area;
    }
    
    

    @Override
    public void run() {
        //int i=0;
        try {
            while (true) {                
                //i++;
                //System.out.println("\nSe esta ejecutando : "+this.mensaje);
                area.append("\nSe esta ejecutando : "+this.mensaje);
                Thread.sleep((int)(Math.random()*10000));
            }
        } catch (Exception e) {
        }
        
    }
    
}
