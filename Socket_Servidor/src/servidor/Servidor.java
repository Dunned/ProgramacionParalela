/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package servidor;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Servidor extends javax.swing.JFrame implements Runnable{
    
    ServerSocket servidor;
    Socket misocket;
    ObjectInputStream flujoEntrada;
    ObjectOutputStream flujoSalida;
    Thread hiloServidor;
    
    public Servidor() {
        try {
            initComponents(); 
            servidor = new ServerSocket(5000);
        } catch (IOException ex) {
            System.err.println("Ocurrio un error "+ex.getMessage());
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        area_Texto = new javax.swing.JTextArea();
        botonEnviar = new javax.swing.JButton();
        inputTexto = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        botonIniciarServidor = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        area_Texto.setColumns(20);
        area_Texto.setRows(5);
        jScrollPane1.setViewportView(area_Texto);

        botonEnviar.setText("Enviar");
        botonEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEnviarActionPerformed(evt);
            }
        });

        jLabel1.setText("Servidor");

        botonIniciarServidor.setText("Iniciar Servidor");
        botonIniciarServidor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonIniciarServidorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 28, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(81, 81, 81)
                .addComponent(botonIniciarServidor)
                .addGap(72, 72, 72))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(inputTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(botonEnviar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(botonIniciarServidor))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(inputTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botonEnviar)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonIniciarServidorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonIniciarServidorActionPerformed
        try {
            area_Texto.append("\n Escucho en el puerto: ");
            misocket =  servidor.accept();
            
            flujoEntrada = new ObjectInputStream(misocket.getInputStream());
            flujoSalida = new ObjectOutputStream(misocket.getOutputStream());
            
            hiloServidor = new Thread(this);
            hiloServidor.start();
            
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_botonIniciarServidorActionPerformed

    private void botonEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEnviarActionPerformed
        
        try {
            
            PaqueteEnvio p1 = new PaqueteEnvio("Servidor", inputTexto.getText());
            
            flujoSalida.writeObject(p1);
            
            area_Texto.append("\n"+p1.getNick()+" "+p1.getMensaje());
            
        } catch (IOException ex) {
            
            System.err.println("Error: "+ex.getMessage());
            
        }
        
 
    }//GEN-LAST:event_botonEnviarActionPerformed

    
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Servidor().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea area_Texto;
    private javax.swing.JButton botonEnviar;
    private javax.swing.JButton botonIniciarServidor;
    private javax.swing.JTextField inputTexto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() { /*LEER MENSAJE*/
        try {
            while (true) {                
                PaqueteEnvio p1 = (PaqueteEnvio) flujoEntrada.readObject();
                area_Texto.append("\n"+p1.getNick()+" "+p1.getMensaje());  
            }
        } catch (Exception e) {
            System.err.println("Error: "+e.getMessage());
        }
   
    }
}

class PaqueteEnvio implements Serializable{
    
    private String nick,mensaje;

    public PaqueteEnvio(String nick, String mensaje) {
        this.nick = nick;
        this.mensaje = mensaje;
    }

    public String getNick() {
        return nick;
    }


    public String getMensaje() {
        return mensaje;
    }

}
