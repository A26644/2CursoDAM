public class Main {
    public static void main(String[] args) {
        Examen examen = new Examen();
        for (int i = 0; i < 5; i++) {
                AlumnoThread alumnoThread = new AlumnoThread(examen);
                alumnoThread.start();
        }
    }
}
