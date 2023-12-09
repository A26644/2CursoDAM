import java.util.Random;

public class Examen {
    private Integer pregunta = 0;
    private ProfesorThread profesorThread;
    private Integer [] examen = {1200, 600, 600, 500};
    private static Integer totalPreguntas = 4;

    public Examen (){
        this.profesorThread = new ProfesorThread(this.getTiempo());
    }

    public Integer getTiempo(){
        Double tiempo = 0.00;
        for (int i = 0; i < examen.length; i++) {
            tiempo += examen[i];
        }
        tiempo = tiempo * 1.25;
        int tiemporound = Math.toIntExact(Math.round(tiempo));
        return tiemporound;
    }

    public Integer getPregunta() {
        return pregunta;
    }

    public void setPregunta(Integer pregunta) {
        this.pregunta = pregunta;
    }

    public static Integer getTotalPreguntas() {
        return totalPreguntas;
    }

    public static void setTotalPreguntas(Integer totalPreguntas) {
        Examen.totalPreguntas = totalPreguntas;
    }

    public Integer[] responderPregunta() {
        if (this.profesorThread.isProfesorEstaEnClase()){
            Random random = new Random();
            Integer preguntaTiempo = random.nextInt(3);
            Integer segundosPregunta = 0;
            Integer[] array = new Integer[3];
            array[0] = getPregunta();
            try {
                switch (preguntaTiempo){
                    case 0:
                        segundosPregunta = random.nextInt(examen[array[0]]);
                        break;
                    case 1:
                        segundosPregunta = examen[array[0]];
                        break;
                    case 2:
                        segundosPregunta = random.nextInt(examen[array[0]]) + examen[array[0]];
                        break;
                }
                array [2] = segundosPregunta;
                Thread.sleep(array[2]);
            } catch (Exception e) {
                System.out.println(e);
            }
            this.pregunta = array[0] + 1;
            array[1] = pregunta;
            return array;
        }else{
            return null;
        }

    }
}
