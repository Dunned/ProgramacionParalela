package Modelo;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;

public class Productor implements Runnable{
    
    private Tuberia tuberia;
    public JLabel label;
    
    public Productor(Tuberia tuberia,JLabel labelContadorP){
        this.tuberia=tuberia;
        this.label=labelContadorP;
    }
    
    
    @Override
    public void run() {
        while(true){
            tuberia.Lanzar(this.label);
        }
        
    }
    
}
