package com.mathias.hilos.ejemplo_executor;

import com.mathias.hilos.ejemplos.ejemploSync.Panaderia;
import com.mathias.hilos.ejemplos.ejemploSync.runnable.Consumidor;
import com.mathias.hilos.ejemplos.ejemploSync.runnable.Panadero;

import java.util.concurrent.*;

public class EjemploExecutorFutureThreadPoolExecutor {
    public static void main(String[] args) throws InterruptedException {

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);

//        Executors.newFixedThreadPool(int hilos); Se indica la cantidad de hilos que se invocan. si se invocan por 3 hilos, se van
//        a realizar todas las tareas al mismo tiempo, en un orden arbitrario, PERO EN ESTE CASO, SE TURNAN, PORQUE LOS METODOS
//        DEL LA CLASE PANADERIA, SON SINCRONIZADOS (synchronized)


        Panaderia panaderia = new Panaderia();
        Consumidor cliente = new Consumidor(panaderia);
        Panadero panadero = new Panadero(panaderia);

        Future<?> futuro1 = executor.submit(cliente);
        Future<?> futuro2 = executor.submit(panadero);

        executor.shutdown();

        System.out.println("Tareas del pool -> " + executor.getPoolSize());
        System.out.println("Tareas en cola -> " + executor.getQueue().size());
    }
}
