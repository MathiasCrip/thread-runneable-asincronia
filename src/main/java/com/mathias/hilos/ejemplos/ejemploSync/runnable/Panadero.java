package com.mathias.hilos.ejemplos.ejemploSync.runnable;

import com.mathias.hilos.ejemplos.ejemploSync.Panaderia;

import java.util.concurrent.ThreadLocalRandom;

public class Panadero implements Runnable {

    private Panaderia panaderia;

    public Panadero(Panaderia panaderia) {
        this.panaderia = panaderia;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                panaderia.hornear("Pan N°: " + i);
                Thread.sleep(ThreadLocalRandom.current().nextInt(200, 500));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
