class Contador {
    private int valor;

    public synchronized int mirarContador() {
        return valor;
    }

    public synchronized void ponerValor(int nuevoValor) {
        valor = nuevoValor;
    }
}
