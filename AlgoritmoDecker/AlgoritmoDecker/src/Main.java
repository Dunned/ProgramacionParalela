public class Main {
    static boolean[] arreglo = {false,false};
    static Thread t1;
    static Thread t2;
    public static void main(String[] args) {
        int[] turno = {1};

        t1=new Thread(new Proceso("X",0,1,arreglo,turno));
        t2=new Thread(new Proceso("Y",1,0,arreglo,turno));

        t1.start();
        t2.start();
    }
}
