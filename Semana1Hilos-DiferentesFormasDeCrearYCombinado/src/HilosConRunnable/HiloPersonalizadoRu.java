package HilosConRunnable;

import HilosConThread.HiloPersonalizado;

public class HiloPersonalizadoRu implements Runnable{

    private String nombre;
    
    public HiloPersonalizadoRu(String nombre){
        this.nombre=nombre;
    }
    
    
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep((int) (Math.random()*(2000-100)) + 100);
                System.out.println(this.nombre+" -> "+i);
            } catch (Exception e) {
                System.err.println("Ocurrio una excepcion: "+e.getMessage());
            }
        }
    }
    
    
    public static void main(String[] args) {
        Thread t1=new Thread(new HiloPersonalizado("HILO 1"));
        Thread t2=new Thread(new HiloPersonalizado("HILO 2"));
        
        t1.start();
        t2.start();
    }
    
    
}
