import java.util.Random;

public class Contador {
    private Integer cuenta = 0;

    public Contador(Integer valorInicial) {
        this.cuenta = valorInicial;
    }

    public Integer getCuenta() {
        return cuenta;
    }

    public void setCuenta(Integer cuenta) {
        this.cuenta = cuenta;
    }

    public synchronized Integer[] incrementarContador() {
        Integer[] array = new Integer[2];
        array[0] = getCuenta();
        Random rand = new Random();
        try {
            Thread.sleep(rand.nextInt(100));
        } catch (Exception e) {
            System.out.println(e);
        }
        cuenta = array[0] + 1;
        array[1] = getCuenta();
        return array;
    }

    public Integer[] decrementarContador() {
        Integer[] array = new Integer[2];
        array[0] = getCuenta();
        cuenta = array[0] - 1;
        array[1] = getCuenta();
        return array;
    }

}
