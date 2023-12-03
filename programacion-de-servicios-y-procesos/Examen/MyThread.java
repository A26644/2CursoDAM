public class MyThread extends Thread {
    private Contador contador;

    public MyThread(Contador contador) {
        this.contador = contador;
    }

    @Override
    public void run() {
        Integer[] myArray = contador.incrementarContador();
        System.out.println("El valor antes de incrementar es: " + myArray[0] + " y el valor despues de incrementar es: "
                + myArray[1]);
    }
}
