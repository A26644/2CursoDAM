package Threads;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        hilo hilo = new hilo();
        hilo.start();
        Thread.sleep(1000);
        System.out.println("Adios");
    }
}
