package Threads;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<Hilo> hilos = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            hilos.add(new Hilo());
        }

        for (Hilo hilo : hilos) {
            hilo.start();
        }
        

        System.out.println("Hasta luego");
    }
}
