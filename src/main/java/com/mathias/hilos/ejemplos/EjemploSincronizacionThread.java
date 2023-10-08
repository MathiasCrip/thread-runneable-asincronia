package com.mathias.hilos.ejemplos;

import com.mathias.hilos.ejemplos.runnable.ImprimirFrases;

public class EjemploSincronizacionThread {
    public static void main(String[] args) {
        new Thread(new ImprimirFrases("Hola", ", que tal?")).start();
        new Thread(new ImprimirFrases("¿quien eres", " tú?")).start();
        new Thread(new ImprimirFrases("¿Muchas", " gracias.")).start();
    }

    /*
        Al agregar la palabra 'synchronized' en el metodo, hace que entre de a un hilo a la vez al metodo,
        y recien cuando termine su ejecución, habilita la entrada para otro hilo
     */
    public synchronized static void imprimirFrases(String frase1, String frase2) {
        System.out.print(frase1);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(frase2);

    }
}
