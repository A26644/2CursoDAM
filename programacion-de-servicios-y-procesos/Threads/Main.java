package Threads;

public class Main {
    public static final Object lock = new Object();
    public static String turno = "A";
    public static int contador = 0;

    public static void main(String[] args) {
        Thread hiloA = new Thread(new MyThread("A"));
        Thread hiloB = new Thread(new MyThread("B"));
        Thread hiloC = new Thread(new MyThread("C"));

        hiloA.start();
        hiloB.start();
        hiloC.start();
    }

    public static void turno() {
        if (turno.equals("A")) {
            turno = "B";
        } else if (turno.equals("B")) {
            turno = "C";
        } else {
            turno = "A";
        }
    }
}
