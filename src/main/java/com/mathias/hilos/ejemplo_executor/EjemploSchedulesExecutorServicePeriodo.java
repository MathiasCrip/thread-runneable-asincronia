package com.mathias.hilos.ejemplo_executor;

import java.util.concurrent.*;

public class EjemploSchedulesExecutorServicePeriodo {
    public static void main(String[] args) throws InterruptedException {

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);

        CountDownLatch count = new CountDownLatch(5);

        System.out.println("Simulando alguna tarea en el main....");

        Future<?> futuro = executor.scheduleAtFixedRate(() -> {

            try {
                TimeUnit.MILLISECONDS.sleep(1000);
                System.out.println("Hola mundo tareas.");
                count.countDown();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }, 1000, 2000, TimeUnit.MILLISECONDS);

        count.await();
        futuro.cancel(true);
        executor.shutdown();
        System.out.println("Alguna otra tarea en el main....");

    }
}
