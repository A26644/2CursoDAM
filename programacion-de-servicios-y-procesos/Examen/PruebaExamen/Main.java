package PruebaExamen;

public class Main {
    public static void main(String[] args) {
        Contador contador = new Contador(0);
        for (int i = 0; i < 100; i++) {
            MyThread miHilo = new MyThread(contador);
            miHilo.start();
        }
    }

}
