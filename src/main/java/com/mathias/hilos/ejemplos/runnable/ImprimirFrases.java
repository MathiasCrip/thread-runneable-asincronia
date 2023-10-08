package com.mathias.hilos.ejemplos.runnable;

import com.mathias.hilos.ejemplos.EjemploSincronizacionThread;

public class ImprimirFrases implements Runnable{

    private String frase1;
    private String frase2;

    public ImprimirFrases(String frase1, String frase2) {
        this.frase1 = frase1;
        this.frase2 = frase2;
    }

    @Override
    public void run() {
        EjemploSincronizacionThread.imprimirFrases(this.frase1, this.frase2);
    }
}
