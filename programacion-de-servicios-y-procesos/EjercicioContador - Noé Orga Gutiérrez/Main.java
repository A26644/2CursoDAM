public class Main {
    public static void main(String[] args) {
        Contador miContador = new Contador();

        // Crear hilos que trabajen con el objeto contador común
        Thread hilo1 = new Thread(new Incrementador(miContador), "Hilo 1");
        Thread hilo2 = new Thread(new Incrementador(miContador), "Hilo 2");

        // Iniciar los hilos
        hilo1.start();
        hilo2.start();

        try {
            // Esperar a que ambos hilos terminen
            hilo1.join();
            hilo2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Valor final del contador: " + miContador.mirarContador());
    }
}
