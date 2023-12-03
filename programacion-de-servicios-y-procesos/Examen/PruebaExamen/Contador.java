package PruebaExamen;

import java.util.Random;

public class Contador {
    private Integer valorActual = 0;

    public Contador(Integer valorActual) {
        this.valorActual = valorActual;
    }

    public synchronized Integer[] incrementarContador() {
        Integer[] array = new Integer[2];
        array[0] = getValorActual();
        try {
            Random random = new Random();
            Thread.sleep(random.nextInt(100));
        } catch (Exception e) {
            System.out.println(e);
        }
        valorActual = array[0] + 1;
        array[1] = valorActual;
        return array;
    }

    public Integer getValorActual() {
        return valorActual;
    }

    public void setValorActual(Integer valorActual) {
        this.valorActual = valorActual;

    }
}
