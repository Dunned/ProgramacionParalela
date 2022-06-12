/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProductorConsumidor;

/**
 *
 * @author eduardo
 */
public class Consumidor extends Thread{
    
    
    Productor productor;
    
    public Consumidor(Productor productor){
        this.productor=productor;
    }

    @Override
    public void run() {
        try {
            
            while (true) {                
                String msj=productor.getMessage();
                System.out.println("Mensaje : "+msj);
                sleep(2000);
            }
            
        } catch (Exception e) {
            System.err.println("Erorr");
        }
    }
    
    
    public static void main(String[] args) {
        Productor p1 = new Productor();
        p1.start();
        new Consumidor(p1).start();
    }
}
