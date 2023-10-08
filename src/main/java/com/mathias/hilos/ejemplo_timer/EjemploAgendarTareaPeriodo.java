package com.mathias.hilos.ejemplo_timer;

import java.awt.*;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class EjemploAgendarTareaPeriodo {
    public static void main(String[] args) {

        Timer timer = new Timer();
//
//      Emite un sonido, dependiendo del sistema operativo donde se implemente.
        Toolkit sonido = Toolkit.getDefaultToolkit();

        timer.schedule(new TimerTask() {
            int contador = 0;

            @Override
            public void run() {
                if (contador != 3) {
                    System.out.println("Tarea periodica N° " + (contador + 1) + " realizada el: " + new Date() + " " + Thread.currentThread().getName());
                    //Imprime un texto + la fecha actual + el nombre del hilo por defecto
                    sonido.beep();
                    contador++;
                } else {
                    System.out.println("Finaliza la tarea.");
                    timer.cancel();
                    //RECORDAR CERRAR EL RECURSO TIMER -> sino, se ejecutaria un bucle infinito.
                }
            }
        }, 2000, 5000);
        //delay: la tarea se empieza a realizar despues de 5 segundos
        //period: la tarea se realiza CADA 5 segundos

        System.out.println("Agendamos una tarea que se repita cada 5 segundos.");
    }
}
