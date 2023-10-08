package com.mathias.hilos.ejemplos;

public class EjemploInterfaceRunnableJava8Join {
    public static void main(String[] args) throws InterruptedException {

        Runnable viaje = () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println(i + " - " + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("Secuencia de hilos " + Thread.currentThread().getName());
        };

        Thread h1 = new Thread(viaje, "Hilo 1");
        Thread h2 = new Thread(viaje, "Hilo 2");
        Thread h3 = new Thread(viaje, "Hilo 3");
        Thread h4 = new Thread(viaje, "Hilo 4");

        h1.start();
        h1.join();

        h2.start();
        h2.join();

        h3.start();
        h3.join();

        h4.start();
        h4.join();


        /* El metodo join, actua sobre la instancia de un hilo. Lo que hace es que el hilo princial (En este caso, el metodo main) tenga
         * que esperar a que terminen los hilos que invocan el join, y recien despues, se ejecuta el metodo de aqui abajo
         */

        System.out.println("Ejecuta el hilo princial -> " + Thread.currentThread().getName());
    }
}
