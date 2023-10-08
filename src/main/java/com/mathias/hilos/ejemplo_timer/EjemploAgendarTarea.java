package com.mathias.hilos.ejemplo_timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/*
La clase Timer de Java es una herramienta que permite a los hilos programar tareas para su ejecución futura
en un hilo en segundo plano. Las tareas pueden programarse para su ejecución única o para su ejecución repetida
a intervalos regulares. Cada objeto Timer tiene un único hilo en segundo plano que se utiliza para ejecutar
todas las tareas del temporizador secuencialmente
 */
public class EjemploAgendarTarea {
    public static void main(String[] args) {

        Timer timer = new Timer();
/*
timer.schedule(TimerTask task, Date time): Programa la tarea especificada para su ejecución en el momento especificado.

timer.schedule(TimerTask task, long delay): Programa la tarea especificada para su ejecución después del retraso especificado.

timer.schedule(TimerTask task, long delay, long period): Programa la tarea especificada para su ejecución después del
 retraso especificado y luego repite la tarea a intervalos regulares.
 */

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Tarea realizada en: " + new Date() + " " + Thread.currentThread().getName());
                //Imprime un texto + la fecha actual + el nombre del hilo por defecto
                System.out.println("Finaliza la tarea.");
                timer.cancel();
                //RECORDAR CERRAR EL RECURSO TIMER -> sino, se ejecutaria un bucle infinito.
            }
        }, 5000);

        System.out.println("Agendamos una tarea para que se realice después de 5 segundos.");
    }
}
