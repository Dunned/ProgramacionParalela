package cliente;

import java.io.*;
import java.net.*;

public class Cliente {

    static final String HOST_NAME="localhost";
    static final int PORT=5000;
    
    public Cliente() {
        try {
            Socket skCliente=new Socket(HOST_NAME,PORT);
            DataInputStream flujoEntrada=
            new DataInputStream(skCliente.getInputStream());
            System.out.println(flujoEntrada.readUTF());
            skCliente.close();
        } catch (Exception e) {
            System.err.println("Ocurrio una excepcion "+e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        new Cliente();
    }
    
}
