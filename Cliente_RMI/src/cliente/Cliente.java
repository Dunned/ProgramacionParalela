package cliente;
import java.rmi.Naming;
import servidor.Servidor;

public class Cliente {
    
    public static String consultar(int id ) throws Exception{
        String resultado = null;
        
        String rmiObjectName="rmi://localhost/Datos";
        
        Servidor servicio = (Servidor)Naming.lookup(rmiObjectName);
        
        
        
        return resultado;
    }
    
    public static void main(String[] args) {
        
    }
}
