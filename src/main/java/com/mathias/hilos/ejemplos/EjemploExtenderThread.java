package com.mathias.hilos.ejemplos;

import com.mathias.hilos.ejemplos.threads.NombreThread;

public class EjemploExtenderThread {
    public static void main(String[] args) throws InterruptedException {

        //Ejemplo usando la clase Thread

        Thread hilo = new NombreThread("hilo 1");
        Thread hilo2 = new NombreThread("hilo 2");

        //Instanciando la clase NombreThread
        NombreThread hilo3 = new NombreThread("hilo 3");

        hilo.start();
        hilo2.start();
        hilo3.start();
//        Thread.sleep(2);
        System.out.println(hilo.getState());

    }
}
