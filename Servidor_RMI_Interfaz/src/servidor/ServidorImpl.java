package servidor;


import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServidorImpl extends UnicastRemoteObject implements Servidor{

    private static  ArrayList<Persona> listPersonas(){
        
        ArrayList<Persona> lista = new ArrayList<Persona>();
        
        lista.add(new Persona(1, "Juan Perez", "Administrador", 2500));
        lista.add(new Persona(2, "Eduardo", "Ing", 2500));
        lista.add(new Persona(3, "Carlos", "Doctor", 2500));
        lista.add(new Persona(4, "Pedro", "Mecanico", 2500));
        lista.add(new Persona(5, "Enrique", "Artista", 2500));
        lista.add(new Persona(6, "Raul", "Futbol", 2500));
        
        return lista;
        
    }
    
    private static String getPersona(int id){
        return "Nombre: "+listPersonas().get(id-1).getNombre()+
                ", Cargo: "+listPersonas().get(id-1).getCargo()+
                ", Sueldo: "+listPersonas().get(id-1).getSueldo();
    }

    public ServidorImpl() throws Exception{
        
    }
    
    
    @Override
    public String consultar(int id) throws Exception {
        return getPersona(id);
    }
    
    
//    public static void main(String[] args) {
//        try {
//            ServidorImpl servidorImpl = new ServidorImpl();
//            System.out.println(servidorImpl.consultar(4));
//        } catch (Exception ex) {
//            Logger.getLogger(ServidorImpl.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

    

}
