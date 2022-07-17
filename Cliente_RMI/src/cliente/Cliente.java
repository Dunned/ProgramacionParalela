package cliente;
import java.rmi.Naming;
import java.util.Scanner;
import servidor.Servidor;

public class Cliente {
    
    public static String consultar(int id ) throws Exception{
        String resultado = null;
        
        String rmiObjectName="rmi://localhost/Datos";
        
        Servidor servicio = (Servidor)Naming.lookup(rmiObjectName);
        
        resultado=servicio.consultar(id);
        
        return resultado;
    }
    
    public static void main(String[] args) throws Exception {
        String op=null;
        int id =-1;
        Scanner scanner;
        do {            
            scanner = new Scanner(System.in);
            System.out.println("Buscar Datos de Empleado: ");
            id=scanner.nextInt();
            System.out.println(consultar(id));
            
            System.out.println("Desea Salir (s)?");
            op=scanner.next();
        } while (op!="s");
        
        scanner.close();
    }
}
