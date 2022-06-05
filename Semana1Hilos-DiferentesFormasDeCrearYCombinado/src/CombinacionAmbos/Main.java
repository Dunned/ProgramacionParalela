/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CombinacionAmbos;

import HilosConRunnable.HiloPersonalizadoRu;
import HilosConThread.HiloPersonalizado;

/**
 *
 * @author eduardo
 */
public class Main {
    public static void main(String[] args) {
        HiloPersonalizado hiloT=new HiloPersonalizado("HILO 1 THREAD");
        Thread hiloR=new Thread(new HiloPersonalizado("HILO 2 RUN"));
        hiloT.start();
        hiloR.start();
    }
}
