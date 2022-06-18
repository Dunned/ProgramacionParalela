package servidor;

import java.io.*;
import java.net.*;


public class Servidor {
    
    static final int port=5000;
    
    
    public Servidor(){
    
        try {
            
            ServerSocket skServidor=new ServerSocket(port);
            System.out.println("Escucha el puerto: "+port);
            
            for(int i=1;i<=3;i++){
                
                Socket skCliente=skServidor.accept();
                System.out.println("Sirvo al cliente "+i);
                DataOutputStream flujosalida=
                        new DataOutputStream(skCliente.getOutputStream());
                flujosalida.writeUTF("Hola Cliente "+i);
                skCliente.close();
            }
            
        } catch (Exception e) {
            
            System.err.println("Ocurrio un error"+e.getMessage());
            
        }
        
    }
    
    
    public static void main(String[] args) {
        new Servidor();
    }
}
