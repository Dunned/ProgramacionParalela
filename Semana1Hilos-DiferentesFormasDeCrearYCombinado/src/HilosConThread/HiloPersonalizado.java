package HilosConThread;

public class HiloPersonalizado extends Thread{
    private String nombre;
    
    public HiloPersonalizado(String nombre){
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
        HiloPersonalizado hilo1=new HiloPersonalizado("HILO 1");
        HiloPersonalizado hilo2=new HiloPersonalizado("HILO 2");
        hilo1.start();
        hilo2.start();
        
    }
}


