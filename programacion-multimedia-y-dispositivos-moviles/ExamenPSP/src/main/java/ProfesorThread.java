public class ProfesorThread extends Thread{
    private int tiempoEspera;
    private boolean profesorEstaEnClase;

    public ProfesorThread(Integer tiempoEspera){
        this.tiempoEspera = tiempoEspera;
        profesorEstaEnClase = true;
        this.start();
    }




    @Override
    public void run() {
        try {
            Thread.sleep(tiempoEspera);
            profesorEstaEnClase = false;
            System.out.println("El profesor se va");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isProfesorEstaEnClase() {
        return profesorEstaEnClase;
    }

    public void setProfesorEstaEnClase(boolean profesorEstaEnClase) {
        this.profesorEstaEnClase = profesorEstaEnClase;
    }
}
