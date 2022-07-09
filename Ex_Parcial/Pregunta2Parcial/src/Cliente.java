import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente extends Thread{
    private int numCliente;
    static String HOST = "localhost";
    static int PUERTO = 5000;
    Socket sc;
    DataOutputStream salida;
    DataInputStream entrada;
    String mensajeRecibido;
    
    public Cliente (int nCli){
        this.numCliente = nCli;
        try{
            sc = new Socket(HOST, PUERTO);
            salida = new DataOutputStream(sc.getOutputStream());
            entrada = new DataInputStream(sc.getInputStream());
//            while(!msn.equals("x")){
//                System.out.println("Escriba un msn para enviar");
//                msn = teclado.nextLine();
//                salida.writeUTF(msn);//enviamos mensaje
//                mensajeRecibido = entrada.readUTF();//Leemos respuesta
//                System.out.println(mensajeRecibido);
//            }
            
        }catch(Exception e){

        }
    }
    
    
    @Override
    public void run(){
        try{
            sleep(2000);
            //bar.inicioCorte(numCliente);
            salida.writeUTF(String.valueOf(numCliente));
            //#bar.finCorte(numCliente);
            salida.writeUTF(String.valueOf(numCliente));
        }catch(InterruptedException ex){
            ex.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}