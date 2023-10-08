package com.mathias.hilos.ejemplo_executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class EjemploExecutorService {
    public static void main(String[] args) throws InterruptedException {

        /*
        La interfaz ExecutorService de Java es una API que simplifica la ejecución de tareas en modo asíncrono.
        En general, se utiliza para ejecutar tareas en segundo plano y proporciona métodos para administrar la terminación
        y métodos que pueden producir un Future para realizar un seguimiento del progreso de una o más tareas asíncronas.
        Un ExecutorService puede ser cerrado, lo que hará que rechace nuevas tareas. Se proporcionan dos métodos diferentes para
        cerrar un ExecutorService. El método shutdown() permitirá que las tareas enviadas previamente se ejecuten antes de la terminación,
        mientras que el método shutdownNow() impide que las tareas en espera comiencen y trata de detener las tareas que se están ejecutando
        actualmente. Al finalizar, un executor no tiene tareas activas en ejecución, no hay tareas esperando ejecución y no se pueden enviar
        nuevas tareas. Un ExecutorService sin usar debe cerrarse para permitir la recuperación de sus recursos.
        El método submit() extiende el método base execute(Runnable) del Executor creando y devolviendo un Future que se puede utilizar
        para cancelar la ejecución y/o esperar a que se complete. Los métodos invokeAny() e invokeAll() realizan las formas más comúnmente
        útiles de ejecución masiva, ejecutando una colección de tareas y luego esperando a que al menos una o todas se completen.
        La clase ExecutorCompletionService se puede utilizar para escribir variantes personalizadas de estos métodos.
        La clase ExecutorService es segura para subprocesos: varios subprocesos pueden compartir un solo objeto ExecutorService
        sin necesidad de sincronización externa.
         */

        ExecutorService executor = Executors.newSingleThreadExecutor();

        Runnable tarea = () -> {
            System.out.println("Inicio de la tarea...");

            try {
                TimeUnit.MILLISECONDS.sleep(5000); //Simula una tarea pesada de 5 segundos
                System.out.println("Nombre del Thread: " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); //Interrumpe el hilo si sale una excepción, y libera el recurso
                throw new RuntimeException(e);
            }

            System.out.println("Finaliza la tarea.");
        };

        executor.submit(tarea);
//        executor.submit: Envía una tarea ejecutable para su ejecución y devuelve un futuro que representa esa tarea.

        System.out.println("Continuando con la ejecucion del metodo main 1");
        executor.shutdown();
//      executor.shutdown: ACORDARSE DE APAGAR EL EJECUTOR!!!
//      Espera a que terminen todas las tareas asignadas y apaga el Excutor

        executor.awaitTermination(2000, TimeUnit.MILLISECONDS);
/*      executor.awaitTermination() :Bloquea el hilo principal hasta que todas las tareas hayan completado su ejecución
        después de una solicitud de cierre, o se agote el tiempo de espera,o se interrumpa el subproceso actual,lo que ocurra primero.
         Como el tiempo de cierre,en este caso, es de 2 Segundos, y la tarea demora 5 segundos, se ejecuta primero el msj de abajo
*/
        System.out.println("Continuando con la ejecucion del metodo main 2");
    }
}
