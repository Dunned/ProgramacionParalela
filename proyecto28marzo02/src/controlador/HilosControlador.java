/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.HilosModel;

/**
 *
 * @author eduardo
 */
public class HilosControlador {
    Thread hilo;
    public void EjecutarInicioModel(String msj){
        hilo=new Thread(new HilosModel(msj));
        hilo.start();
    
    }
    
    public void EjecutarStopModel(){
        hilo.stop();  
    }
    
    
    
}
