
package Ejercicio2CronometroHilos;

import javax.swing.JOptionPane;


public class CronometroRun implements Runnable{

    @Override
    public void run() {
        int segundos=0;
        int tiempseg=0;
        int minutos=0;
        int segtotales=0;
        
        tiempseg=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el Tiempo"));
        
        try {
            
            while (true) {                
                Thread.sleep(1000);
                segundos++;
                segtotales++;
                System.out.println("El tiempo es "+minutos+" min con "+segundos+" segundos");
                if (segundos==60) {
                    minutos++;
                    segundos=0;
                }
                
                if (segtotales==tiempseg) {
                    //System.out.println("El tiempo es "+minutos+" min con "+segundos+" segundos");
                    System.exit(0);
                }
                
            }
            
        } catch (Exception e) {
            segundos++;
            segtotales++;
        }
    }
    
    public static void main(String[] args) {
        Thread h1=new Thread(new CronometroThread());
        h1.start();
    }
}
