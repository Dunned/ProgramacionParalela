/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author eduardo
 */
public class Main {
    public static void main(String[] args) {
        String str="";

        Rojo r=new Rojo(str);
        Verde v=new Verde(str);

        Thread t1=new Thread(r);
        Thread t2=new Thread(v);
        t2.start();
        t1.start();
    }

}
