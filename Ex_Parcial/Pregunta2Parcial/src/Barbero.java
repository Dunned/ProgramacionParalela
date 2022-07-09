
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Barbero extends Thread{
    public boolean ocupado;
    public boolean[] sillas = new boolean[5];
    static int PUERTO = 5000;
    ServerSocket sc;
    Socket so;
    DataOutputStream salida;
    DataInputStream entrada;
    String mensajeRecibido;
    
   
    public Barbero(boolean ocupado){    
        try{
            sc = new ServerSocket(PUERTO);
            so = new Socket();

            System.out.println("Clientes");
            so = sc.accept();
            System.out.println("Nuevo Cliente");
            entrada = new DataInputStream(so.getInputStream());
            salida = new DataOutputStream(so.getOutputStream());
//            while(!msn.equals("x")){
//                mensajeRecibido = entrada.readUTF();//Leemos respuesta
//                System.out.println(mensajeRecibido);
//                System.out.println("Escriba un msn para enviar");
//                salida.writeUTF(""+msn);//enviamos mensaje
//            }
        }catch(Exception e){
            
        }
        this.ocupado = ocupado;
    }
    
    public synchronized void ocuparSilla(int numClie){
        System.out.println("Silla ocupada por el cliente número: " + numClie);
    }    
    
    public synchronized void dejarSilla(int numClie){
        while(isOcupado()){
            try{
                wait();
            }catch(InterruptedException ex){
                
            }
        }
        System.out.println("El cliente " + numClie + " deja libre una silla");
    }
    
    public synchronized void inicioCorte(int numClie){
        while(isOcupado()){
            System.out.println("Barbero ocupado, " + numClie + " espera");
            try{
                wait();
            }catch(InterruptedException ex){
                
            }
        }
        this.setOcupado(true);
        System.out.println("El barbero empieza a cortar el pelo al cliente " + numClie);
    }
    
    public synchronized void finCorte(int numClie){
        this.setOcupado(false);
        System.out.println("El barbero termina de cortar el pelo al cliente " + numClie);
        notify();
    }
    
    public boolean isOcupado(){
        return ocupado;
    }
    
    public void setOcupado(boolean ocupado){
        this.ocupado = ocupado;
    }

    @Override
    public void run() {
        while (true) {
            try {
                if (mensajeRecibido!=null){
                    mensajeRecibido = entrada.readUTF();//Leemos respuesta
                    this.inicioCorte(Integer.parseInt(mensajeRecibido));
                    this.finCorte(Integer.parseInt(mensajeRecibido));
                }
            } catch (IOException ex) {
                Logger.getLogger(Barbero.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
}