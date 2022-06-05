import java.awt.Component;

public class PelotaHilos implements Runnable{
    
    private Pelota pelota;
    private Component componente;
    
    
    public PelotaHilos(Pelota unaPelota,Component unComponente){
        this.pelota=unaPelota;
        this.componente=unComponente;
    }

    
    @Override
    public void run() { /*TAREA QUE SEA SIMULTANEA*/
        System.out.println("ESTADO DEL HILO AL COMENZAR"+
                Thread.currentThread().isInterrupted());
        //for (int i=1; i<=3000; i++){
        while (!Thread.currentThread().isInterrupted()) {            
            
            this.pelota.mueve_pelota(componente.getBounds());
            this.componente.paint(componente.getGraphics());
            
            try {

                Thread.sleep(1); //PAUSA DORMIR HILO 2ms

            } catch (Exception e) {
                Thread.currentThread().interrupt();
                //System.err.println("Hilo Bloqueado , imposible su Interrupcion "+e.getMessage());

            }
        
        }
        System.out.println("ESTADO DEL HILO AL COMENZAR"+
                Thread.currentThread().isInterrupted());
    }
    
}
