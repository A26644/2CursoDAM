package Threads;

public class Hilo extends Thread {
    private int numeroHilo;
    private static int numero = 0;

    public Hilo() {
        numeroHilo = numero;
        numero++;
    }

    public void run() {
        System.out.println("Hola mundo, soy el hilo " + numeroHilo);
    }
}
