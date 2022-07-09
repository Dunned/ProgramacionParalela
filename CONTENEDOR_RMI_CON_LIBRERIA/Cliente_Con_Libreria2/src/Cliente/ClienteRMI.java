/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cliente;

import Interfaz.RMI;
import javax.swing.JOptionPane;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;


public class ClienteRMI {
    
    public static void main(String[] args) {
        ClienteRMI objeto = new ClienteRMI();
        objeto.ConectarCliente();
    }
    
    
    public void ConectarCliente(){
        
        try {
            /*
            Implementamos interfaz y generamos nueva para RMI , para que busque objeto remoto alojado en Servidor
            */
            Registry registro = LocateRegistry.getRegistry("127.0.0.1", 7777);
            RMI interfaz= (RMI) registro.lookup("RemotoRMI");
            
            /*MULTIPLICACION*/
            String num1cad = JOptionPane.showInputDialog("Primer Valor");
            int num1 = Integer.parseInt(num1cad);
            
            String num2cad = JOptionPane.showInputDialog("Segundo Valor");
            int num2 = Integer.parseInt(num2cad);
            
            JOptionPane.showMessageDialog(null, "El Producto es: "+interfaz.producto(num1, num2));
            
            
            /*FACTORIAL*/
            String factcad = JOptionPane.showInputDialog("Ingrese el numero del Factorial: ");
            int variable = Integer.parseInt(factcad);
            JOptionPane.showMessageDialog(null, "El Factorial es: "+interfaz.CalcularFactorial(variable));
            
            
            /*MAYOR*/
            String var1 = JOptionPane.showInputDialog("Primer Valor");
            int nro1 = Integer.parseInt(var1);
            
            String var2 = JOptionPane.showInputDialog("Segundo Valor");
            int nro2 = Integer.parseInt(var2);
            
            JOptionPane.showMessageDialog(null, "El Mayor es: "+interfaz.CalcularMayor(nro1, nro2));
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "Ocurrio una excepcion: "+e.getMessage());
        }
        
    }
    
}
