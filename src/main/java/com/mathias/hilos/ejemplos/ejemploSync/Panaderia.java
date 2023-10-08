package com.mathias.hilos.ejemplos.ejemploSync;

public class Panaderia {
    private String pan;
    private boolean disponible;

    public synchronized void hornear(String masa) {
        this.pan = masa;

        while (disponible) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

        System.out.println("Hilo hornear -> " + Thread.currentThread().getName());
        System.out.println("Panadero hornea el " + this.pan);
        this.disponible = true;
        notify();

    }

    public synchronized void consumir() {
        while (!disponible) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("-----------------------------");
        System.out.println("Hilo cliente -> " + Thread.currentThread().getName());
        System.out.println("El cliente consume " + this.pan);
        System.out.println("-----------------------------");

        this.disponible = false;
        notify();
    }
}
