import java.io.BufferedWriter;
import java.io.FileWriter;
import java.lang.reflect.Field;
import java.util.List;

public class XMLMapper {

    public static String transformar(String nombre, List<?> lst) {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
        xml += "<" + nombre + ">";
        for (Object object : lst) {
            Class<?> claseX = object.getClass();
            String nombreClase = claseX.getName();
            xml += "<" + nombreClase + ">";
            Field[] campos = claseX.getDeclaredFields();
            for (Field campo : campos) {
                String nombreCampo = campo.getName();
                xml += "<" + nombreCampo + ">";
                Object valorCampo = null;
                campo.setAccessible(true);
                try {
                    valorCampo = campo.get(object);
                } catch (Exception e) {
                    valorCampo = null;
                } finally {
                    xml += valorCampo;
                    xml += "</" + nombreCampo + ">";
                }
            }
            xml += "</" + nombreClase + ">";
        }
        xml += "</" + nombre + ">";
        return xml;
    }

    public static void exportarArchivo(String xml, String rutaArchivo) {
        try {
            FileWriter fileWriter = new FileWriter(rutaArchivo);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(xml);
            bufferedWriter.close();
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
