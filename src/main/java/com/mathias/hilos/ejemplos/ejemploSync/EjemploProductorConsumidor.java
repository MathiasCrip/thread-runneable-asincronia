package com.mathias.hilos.ejemplos.ejemploSync;

import com.mathias.hilos.ejemplos.ejemploSync.runnable.Consumidor;
import com.mathias.hilos.ejemplos.ejemploSync.runnable.Panadero;

public class EjemploProductorConsumidor {
    public static void main(String[] args) {

        Panaderia panaderia = new Panaderia();
        new Thread(new Panadero(panaderia)).start();
        new Thread(new Consumidor(panaderia)).start();
    }
}
