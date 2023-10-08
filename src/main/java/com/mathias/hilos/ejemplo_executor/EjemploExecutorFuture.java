package com.mathias.hilos.ejemplo_executor;

import java.util.concurrent.*;

public class EjemploExecutorFuture {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

        ExecutorService executor = Executors.newSingleThreadExecutor();

        //Callable<?> la diferencia con Executor, es que éste, retorna el objeto futuro. Acepta cualquier tipo de retorno
        Callable<String> tarea = () -> {

            System.out.println("Inicio de la tarea...");

            try {
                TimeUnit.MILLISECONDS.sleep(5000); //Simula una tarea pesada de 5 segundos
                System.out.println("Nombre del Thread: " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); //Interrumpe el hilo si sale una excepción, y libera el recurso
                throw new RuntimeException(e);
            }

            System.out.println("Finaliza la tarea.");
            return "algun resultado de la tarea.";
        };

        /*
     Un Future es una interfaz que representa el resultado futuro de una computación asíncrona. Proporciona métodos para verificar
      si la computación ha finalizado, esperar a que se complete y recuperar el resultado de la computación. El resultado solo se
      puede recuperar utilizando el método get(), cuando la computación ha finalizado, bloqueando si es necesario hasta que esté listo.
         */

        Future<?> resultado = executor.submit(tarea);
//      executor.submit: Envía una tarea ejecutable para su ejecución y devuelve un futuro que representa esa tarea.

        executor.shutdown();
//      executor.shutdown: ACORDARSE DE APAGAR EL EJECUTOR!!!
//      Espera a que terminen todas las tareas asignadas y apaga el Excutor

        System.out.println("Continuando con la ejecucion del metodo main");

        System.out.println("Resultado futuro: " + resultado.isDone());
//        Primero es false, porque todavia no se terminó la tarea (demora de 3 seg)

        System.out.println("Resultado futuro: " + resultado.get());
//        Espera, si es necesario, a que se complete el cálculo y luego recupera su resultado.
//        El tema con el get(), es que si no termina la ejecución de la tarea, queda esperando indefinidamente, por
//        eso es aconcejable manejar algun tipo de validacion en el tiempo y terminar el proceso, en este caso, como es una simulación
//        de 3 seg, sabemos que se va a terminar a ese tiempo.

        System.out.println("Resultado futuro: " + resultado.isDone());
//        El resultado futuro es true, porque ya termine la tarea


    }
}
