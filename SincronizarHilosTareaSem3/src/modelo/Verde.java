package modelo;


public class Verde implements Runnable{

    public String cadena;

    public Verde(String cadena) {
        this.cadena = cadena;
    }
    
    
    @Override
    public void run() {
        while(true){
            try {
            Thread.sleep(1000);
            synchronized (cadena) {      
                cadena=cadena+"L1";
                System.out.println("VERDE: "+cadena);
                notify();
            }
            } catch (Exception e) {
        }
        }
    }
    

}

