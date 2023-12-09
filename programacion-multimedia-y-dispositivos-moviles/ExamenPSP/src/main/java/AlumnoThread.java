import java.util.Random;

public class AlumnoThread extends Thread {
    private Examen examen;
    private static Integer numeroAlumnoStatic = 0;
    private Integer numeroAlumno = 0;


    public AlumnoThread(Examen examen) {
        this.numeroAlumno = numeroAlumnoStatic;
        numeroAlumnoStatic++;
        this.examen = examen;
    }

    @Override
    public void run() {
        for (int i = 0; i < Examen.getTotalPreguntas(); i++) {
            Integer[] array = examen.responderPregunta();
            if (array != null) {
                System.out.println("Soy el alumno numero " + numeroAlumno + " y acabo de responder la pregunta " + array[0] + " en " + array[2] + " segundos y ahora voy a responder la pregunta " + array[1]);

            } else {
                System.out.println("El profesor ya se ha ido");
            }
        }
    }


}
