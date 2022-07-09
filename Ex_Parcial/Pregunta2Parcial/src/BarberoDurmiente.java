public class BarberoDurmiente {

    public static void main(String[] args) {
        

        for (int i =0; i<10;i++){
            Cliente c = new Cliente(i+1);
            c.start();
        }
        
        Barbero barbero = new Barbero(false);
        barbero.start();
        
    }
}