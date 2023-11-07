package Threads;

public class MyThread implements Runnable {
    private String ID;
    private int counter;

    public MyThread(String ID) {
        this.counter = 0;

        this.ID = ID;
    }

    @Override
    public void run() {
        while (counter < 9) {
            synchronized (Main.lock) {
                while (!ID.equals(Main.turno)) {
                    try {
                        Main.lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Hola soy el hilo " + ID);
                counter++;
                Main.turno();
                Main.lock.notifyAll();
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
