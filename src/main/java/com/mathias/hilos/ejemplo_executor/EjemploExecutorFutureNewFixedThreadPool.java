package com.mathias.hilos.ejemplo_executor;

import java.util.concurrent.*;

public class EjemploExecutorFutureNewFixedThreadPool {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

        ExecutorService executor = Executors.newSingleThreadExecutor();
//        Executors.newSingleThreadExecutor : Las tareas realizadas son por un único hilo, no se procesan de manera paralela, sino, de una tarea a la vez

        //Callable<?> la diferencia con Executor, es que éste, retorna el objeto futuro. Acepta cualquier tipo de retorno
        Callable<String> tarea_1 = () -> {
            try {
                System.out.println("Inicio de la tarea");

                TimeUnit.MILLISECONDS.sleep(5000); //Simula una tarea que dura 5 segundos
                System.out.println("Nombre del Thread: " + Thread.currentThread().getName().toUpperCase());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); //Interrumpe el hilo si sale una excepción, y libera el recurso
                throw new RuntimeException(e);
            }

            System.out.println("Finaliza la tarea.");
            return "algun resultado de la tarea.";
        };

        Callable<Integer> tarea2 = () -> {
            System.out.println("Iniciando tarea 3");
            System.out.println("Nombre del Thread: " + Thread.currentThread().getName().toUpperCase());
            TimeUnit.MILLISECONDS.sleep(3000); //Simula una tarea que dura 3 segundas
            return 18;
        };

        /*
     Un Future es una interfaz que representa el resultado futuro de una computación asíncrona. Proporciona métodos para verificar
      si la computación ha finalizado, esperar a que se complete y recuperar el resultado de la computación. El resultado solo se
      puede recuperar utilizando el método get(), cuando la computación ha finalizado, bloqueando si es necesario hasta que esté listo.
         */

        Future<?> resultado = executor.submit(tarea_1);
        Future<String> resultado2 = executor.submit(tarea_1);
        Future<Integer> resultado3 = executor.submit(tarea2);
//      executor.submit: Envía una tarea ejecutable para su ejecución y devuelve un futuro que representa esa tarea.

        executor.shutdown();
//      executor.shutdown: ACORDARSE DE APAGAR EL EJECUTOR!!!
//      Espera a que terminen todas las tareas asignadas y apaga el Excutor


        while (!(resultado.isDone() && resultado2.isDone() && resultado3.isDone())) {
            System.out.println(String.format("Resultado1: %s - Resultado2: %s - Resultado3: %s",
                    resultado.isDone() ? "finalizó" : "en proceso",
                    resultado2.isDone() ? "finalizó" : "en proceso",
                    resultado3.isDone() ? "finalizó" : "en proceso"));

            TimeUnit.MILLISECONDS.sleep(1500);
//            imprime cada 1.5 segundos
        }

        System.out.println("Continuando con la ejecucion del metodo main");

        System.out.println("Resultado de la tarea1: " + resultado.get());
//        Espera, si es necesario, a que se complete el cálculo y luego recupera su resultado.
//        El tema con el get(), es que si no termina la ejecución de la tarea, queda esperando indefinidamente, por
//        eso es aconcejable manejar algun tipo de validacion en el tiempo y terminar el proceso, en este caso, como es una simulación
//        de 3 seg, sabemos que se va a terminar a ese tiempo.

        System.out.println("Resultado de la tarea2: " + resultado2.isDone());
        System.out.println("Resultado de la tarea3: " + resultado3.isDone());
//        El resultado futuro es true, porque ya termine la tarea


    }
}
