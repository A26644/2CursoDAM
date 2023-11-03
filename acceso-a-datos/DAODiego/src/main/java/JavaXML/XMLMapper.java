package JavaXML;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
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

    public static void exportarArchivo(String xml, String nombreXML) {
        File fichero = null;
        FileWriter writer;
        PrintWriter pw;
        try {
            fichero = new File(".\\src\\main\\java\\xml\\" + nombreXML + ".xml");
            writer = new FileWriter(fichero);
            pw = new PrintWriter(writer);
            pw.println(xml);
            writer.close();
        } catch (Exception e) {
            System.out.println(e);
        } finally {

        }

    }
}
