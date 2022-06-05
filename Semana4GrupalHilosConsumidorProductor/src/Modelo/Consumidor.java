
package Modelo;

import java.awt.Color;
import java.util.List;
import javax.swing.JLabel;


public class Consumidor implements Runnable{
    
    private Tuberia tuberia;
    public JLabel label;
    
    public Consumidor(Tuberia tuberia,JLabel labelContadorC){
        this.tuberia=tuberia;
        this.label=labelContadorC;
    }

    @Override
    public void run() {
        while (true) {            
            tuberia.Recoger(this.label);
        }
    }
    
}
