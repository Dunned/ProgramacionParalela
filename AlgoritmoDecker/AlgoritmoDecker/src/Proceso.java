public class Proceso implements Runnable {

     String nombre;
     int numero;
     int siguiente;
     boolean[] arreglo;
     int[] turno;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(int siguiente) {
        this.siguiente = siguiente;
    }

    public boolean[] getArreglo() {
        return arreglo;
    }

    public void setArreglo(boolean[] arreglo) {
        this.arreglo = arreglo;
    }

    public int[] getTurno() {
        return turno;
    }

    public void setTurno(int[] turno) {
        this.turno = turno;
    }

    Proceso(String nombre, int numero, int siguiente, boolean[] arreglo,
            int[] turno){
        this.nombre=nombre;
        this.numero=numero;
        this.siguiente=siguiente;
        this.arreglo=arreglo;
        this.turno=turno;
    }

    @Override
    public void run() {
        this.arreglo[numero]=true;
        while(arreglo[siguiente]){
            this.arreglo[numero]=false;
            while (turno[0]!=numero){
                System.out.println("El proceso : "+this.nombre+" esta esperando");
            }
            this.arreglo[numero]=true;
        }
        // SECCION CRITICA
        for (int i = 0; i < 10; i++) {
            if (i==9){
                System.out.println("El proceso: "+this.nombre+" termino");
            }
            else {
                System.out.println("Se esta ejecutando el proceso: "+this.nombre);
            }
        }

        this.arreglo[numero]=false;
        turno[0]=siguiente;

    }
}
