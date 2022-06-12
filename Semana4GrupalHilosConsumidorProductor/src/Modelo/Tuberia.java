
package Modelo;

import Controlador.Controlador;
import java.awt.Color;
import java.util.List;
import javax.swing.JLabel;


public class Tuberia {
    
    private List<String> productos;
    private List<JLabel> labels;
    
    public Tuberia(List<String> productos, List<JLabel> labels) {
        this.productos = productos;
        this.labels = labels;
    }
    

    public void Lanzar(JLabel labelP){
        try {
            synchronized(productos){
                if (productos.size()<4){
                    Thread.sleep((int) (Math.random()*(3000-1)) + 1);
                    int posicion=productos.size();
                    System.out.println(productos);
                    productos.add("producto");
                    Controlador.contadorProducido++;
                    labelP.setText(String.valueOf(Controlador.contadorProducido));
                    labels.get(posicion).setBackground(Color.red);
                }
                
                if (productos.size()==4) {
                    productos.notify();
                }
            }
            
        } catch (Exception e) {
            System.err.println("ERROR EN LANZAMIENTINTO "+e.getMessage());
        }  
    }
    
    public void Recoger(JLabel labelC){
        try {   
            synchronized (productos) {
                if (productos.size()!=4){ 
                    productos.wait();
                }
                
                while(productos.size()>0){
                      int posicion=productos.size()-1;
                      Thread.sleep((int) (Math.random()*(3000-1)) + 1); 
                      Controlador.contadorConsumido++;
                      labelC.setText(String.valueOf(Controlador.contadorConsumido));
                      System.out.println(productos);
                      productos.remove(0);
                      labels.get(posicion).setBackground(Color.YELLOW);
                }                
            }
        } catch (Exception e) {
            System.err.println("ERROR EN RECOGER "+e.getMessage());
        }
    }
    
}
