package com.mathias.hilos.ejemplos;

public class EjemploInterfaceRunnableJava8 {
    public static void main(String[] args) {
        /*
           Ejemplo de la interfaz Runnable usando  expresión lambda () ->{}
         */
        Runnable viaje = () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println(i + " - " + Thread.currentThread().getName());
                try {
                    //Tiempo que simula una tarea de 1 Segundo
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("Secuencia de hilos" + Thread.currentThread().getName());
        };

        new Thread(viaje, "Hilo 1").start();
        new Thread(viaje, "Hilo 2").start();
        new Thread(viaje, "Hilo 3").start();
        new Thread(viaje, "Hilo 4").start();
    }
}
