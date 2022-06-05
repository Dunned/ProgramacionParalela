package Controlador;

import Modelo.Consumidor;
import Modelo.Productor;
import Modelo.Tuberia;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;


public class Controlador {
    List<String> productos;
    private List<JLabel> labels;
    public static int contadorProducido=0;
    public static int contadorConsumido=0;
    public JLabel producido;
    public JLabel consumido;
    Thread productor;
    Thread consumidor;
    
    public Controlador(List<JLabel> labels,JLabel producido,JLabel consumido) {
        this.productos=new ArrayList<String>();
        this.labels=labels;
        this.producido=producido;
        this.consumido=consumido;
    }
    
    
    public void ejecutar() {
        Tuberia tuberia=new Tuberia(this.productos, this.labels);
        
        productor=new Thread(new Productor(tuberia,producido));
        consumidor=new Thread(new Consumidor(tuberia,consumido));

        productor.start();
        consumidor.start();
    }
    
    public void parar(){
        productor.stop();
        consumidor.stop();
    }
       
}
