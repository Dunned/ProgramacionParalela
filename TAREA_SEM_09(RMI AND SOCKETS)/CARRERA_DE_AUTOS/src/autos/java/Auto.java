
package autos.java;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JProgressBar;

public class Auto implements Runnable   {
    
    public String nombre;
    public JProgressBar barra;
    public boolean ganador;
    public Carrera carrera;
    int validar=0;

    public Auto(String nombre, JProgressBar barra,Carrera carrera) {
        this.nombre = nombre;
        this.barra = barra;
        this.ganador=false;
        this.carrera=carrera;
    }
    

    @Override
    public void run() {
        for (int i=1; i<=100 ; i++){
            try {
                sleep(2 + (int)(Math.random() * 70));
                this.barra.setValue(i);
                if (carrera.ganador!="-") {
                    validar=1;
                    break;
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Carrera.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (validar==0) {
            carrera.ganador=nombre;
        }
    }
    

    
}
