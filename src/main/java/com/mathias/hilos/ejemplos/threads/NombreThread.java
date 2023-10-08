package com.mathias.hilos.ejemplos.threads;

public class NombreThread extends Thread {
    public NombreThread(String name) {
        super(name);
    }

    private String nombre;

    @Override
    public void run() {
        System.out.println("Se inicial el metodo run del hilo: " + getName());

        for (int i = 0; i < 10; i++) {
            System.out.println(this.getName());
        }

        System.out.println("Finaliza el hilo: " + getName());
    }
}
