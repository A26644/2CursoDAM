package PruebaExamen;

public class MyThread extends Thread {

    private Contador contador;

    public MyThread(Contador contador) {
        this.contador = contador;
    }

    @Override
    public void run() {
        Integer[] array = contador.incrementarContador();
        System.out.println("El valor anterior era: " + array[0] + " y el siguiente valor es: " + array[1]);

    }
}
