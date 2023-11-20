public class Incrementador implements Runnable {
    private Contador contador;

    public Incrementador(Contador contador) {
        this.contador = contador;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (contador) {
                int valorActual = contador.mirarContador();
                if (valorActual >= 100) {
                    break;
                }
                int nuevoValor = valorActual + 1;
                contador.ponerValor(nuevoValor);
                System.out.println("Hilo " + Thread.currentThread().getName() + ": Contador = " + nuevoValor);
            }
        }
    }
}
