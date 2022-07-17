package servidor;


import java.rmi.Naming;

public class ServidorProceso {
    public static void main(String[] args) throws Exception {
        ServidorImpl servidor = new ServidorImpl();
        String rmiObjectName = "rmi://localhost/Datos";
        Naming.rebind(rmiObjectName,servidor);
        System.out.println("Servidor Remoto Corriendo");
    }
}
