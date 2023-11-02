package Threads;

public class Hilo extends Thread {
    private int numeroHilo;
    private static int numero = 0;

    public Hilo() {
        numeroHilo = numero;
        numero++;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Hola mundo, soy el hilo " + numeroHilo);
            try {
                this.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }
}
