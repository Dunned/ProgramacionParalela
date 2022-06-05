package modelo;


public class Rojo implements Runnable{

    public String cadena;

    public Rojo(String cadena) {
        this.cadena = cadena;
    }
    
    
    @Override
    public void run() {
        while (true) {            
            try {
            Thread.sleep(1000);
            synchronized (cadena) {      
                cadena=cadena+"L2   ";
                System.out.println("ROJO: "+cadena);
                wait();
            }
            } catch (Exception e) {
            }
        }
    }
    

}

