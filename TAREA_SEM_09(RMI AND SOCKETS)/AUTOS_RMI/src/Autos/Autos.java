package Autos;

import java.awt.EventQueue;
import java.awt.Color;
import java.util.UUID;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

//empezaremos a crear las variables que contendrán los progressbar y el JFrame
//y también la variable para el hilo
public class Autos {

    JFrame JFrame;
    JLabel jLabel1;
    JProgressBar hilo1 = new JProgressBar(0, 100);
    JProgressBar hilo2 = new JProgressBar(0, 100);
    JProgressBar hilo3 = new JProgressBar(0, 100);
    JProgressBar hilo4 = new JProgressBar(0, 100);

    // Se coloca el JLabel para mandar el mensaje de que carro ganó
//    JLabel mensaje = new JLabel("");

   
    static boolean Iniciar = false;
    static int Auto_ganador = 0;
    static boolean Ganador = false;

    public synchronized void finish(int i) {
//        mensaje.setVisible(true);
        //Mensaje que aparecerá cuando ya llego un auto a la meta
//        mensaje.setText("Ganó la carrera, El Auto: " + Auto_ganador + " ");
        if (i == 100) {
            Ganador = true;
            System.out.println("Ganó la carrera, El Auto: " + Auto_ganador + " ");
        }
//        JFrame.getContentPane().add(mensaje);

    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Autos window = new Autos();
                    window.JFrame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Autos() {
        iniciar();
    }

    private void iniciar() {

        JFrame = new JFrame();
        JFrame.setBounds(150, 150, 598, 430);
        JFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JFrame.getContentPane().setLayout(null);

        jLabel1 = new JLabel("SERVIDOR");
        jLabel1.setBounds(250, 5, 259, 34);
        JFrame.getContentPane().add(jLabel1);

        hilo1.setStringPainted(true);
        hilo1.setForeground(Color.red);
        hilo1.setBounds(150, 55, 259, 34);
        JFrame.getContentPane().add(hilo1);

        hilo2.setStringPainted(true);
        hilo2.setForeground(Color.BLUE);
        hilo2.setBounds(150, 109, 259, 34);
        JFrame.getContentPane().add(hilo2);

        hilo3.setStringPainted(true);
        hilo3.setForeground(Color.RED);
        hilo3.setBounds(150, 155, 259, 34);
        JFrame.getContentPane().add(hilo3);

        hilo4.setStringPainted(true);
        hilo4.setForeground(Color.YELLOW);
        hilo4.setBounds(150, 205, 259, 34);
        JFrame.getContentPane().add(hilo4);
    }

    public void iniciarCarrera() {
        if (!Iniciar) {
            Iniciar = true;

            AutoRojo hilo1 = new AutoRojo();
            hilo1.start();

            AutoAzul hilo2 = new AutoAzul();
            hilo2.start();

            AutoRojo1 hilo3 = new AutoRojo1();
            hilo3.start();

            AutoAmarillo hilo4 = new AutoAmarillo();
            hilo4.start();
        }
    }

//Llamamos la clase AutoRojo hilo1
    class AutoRojo extends Thread {

        public void reset() {
            hilo1.setValue(0);
            hilo1.repaint();
        }

        public void run() {
            for (int i = 0; i < 101; i++) {
                if (Ganador) {
                    break;
                }
                hilo1.setValue(i);
                hilo1.repaint();
                if (i == 100) {
                    Auto_ganador = 1;
                    finish(i);
                }
                try {
                    Thread.sleep(Math.abs(UUID.randomUUID().getMostSignificantBits()) % 60);
                } catch (InterruptedException err) {
                    err.printStackTrace();
                }
            }
        }
    }

    //Llamamos la clase AutoAzul hilo2
    class AutoAzul extends Thread {

        public void reset() {
            hilo2.setValue(0);
            hilo2.repaint();
        }

        public void run() {
            for (int i = 0; i < 101; i++) {
                if (Ganador) {
                    break;
                }
                hilo2.setValue(i);
                hilo2.repaint();
                if (i == 100) {
                    Auto_ganador = 2;
                    finish(i);
                }
                try {
                    Thread.sleep(Math.abs(UUID.randomUUID().getMostSignificantBits()) % 60);
                } catch (InterruptedException err) {
                    err.printStackTrace();
                }
            }
        }
    }

    //Llamamos la clase AutoRojo1 hilo3
    class AutoRojo1 extends Thread {

        public void reset() {
            hilo3.setValue(0);
            hilo3.repaint();
        }

        public void run() {
            for (int i = 0; i < 101; i++) {
                if (Ganador) {
                    break;
                }
                hilo3.setValue(i);
                hilo3.repaint();
                if (i == 100) {
                    Auto_ganador = 3;
                    finish(i);
                }
                try {
                    Thread.sleep(Math.abs(UUID.randomUUID().getMostSignificantBits()) % 60);
                } catch (InterruptedException err) {
                    err.printStackTrace();
                }
            }
        }
    }
    
    
//Llamamos la clase AutoAmarillo hilo4
    class AutoAmarillo extends Thread {

        public void reset() {
            hilo4.setValue(0);
            hilo4.repaint();
        }

        public void run() {
            for (int i = 0; i < 101; i++) {
                if (Ganador) {
                    break;
                }
                hilo4.setValue(i);
                hilo4.repaint();
                if (i == 100) {
                    Auto_ganador = 4;
                    finish(i);
                }
                try {
                    Thread.sleep(Math.abs(UUID.randomUUID().getMostSignificantBits()) % 60);
                } catch (InterruptedException err) {
                    err.printStackTrace();
                }
            }
        }
    }
}

