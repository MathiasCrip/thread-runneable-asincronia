package com.mathias.hilos.ejemplo_executor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class EjemploSchedulesExecutorService {
    public static void main(String[] args) {

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);

        System.out.println("Simulando alguna tarea en el main....");

        /*
        schedule -> Envía una tarea de una sola vez que se habilita después del retraso indicado.
         */
        executor.schedule(() -> {

                System.out.println("Hola mundo tareas.");


        }, 2000, TimeUnit.MILLISECONDS); //retraso del inicio de la tarea

        executor.shutdown(); //Se apaga el executor
        System.out.println("Alguna otra tarea en el main....");
    }
}
