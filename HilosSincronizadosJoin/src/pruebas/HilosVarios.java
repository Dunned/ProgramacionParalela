package pruebas;



public class HilosVarios extends Thread{
    
    

    @Override
    public void run() {
        for (int i=0;i<15;i++){
            try {
                System.out.println("Ejecutando Hilo"+this.getName());
                Thread.sleep(500);
            } catch (InterruptedException e) {
            }
        }
    }
    
}



