package JavaXML;

import java.util.ArrayList;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import model.Empresa;
import model.Particular;

public class Inserts {
    public static ArrayList<Empresa> insertIntoEmpresa(NodeList nodeList) {
        ArrayList<Empresa> lstEmpresa = new ArrayList<>();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Element empresa = (Element) nodeList.item(i);
            String empresaNombre = empresa.getElementsByTagName("empresaNombre").item(0).getTextContent();
            String empresaCif = empresa.getElementsByTagName("empresaCif").item(0).getTextContent();
            String empresaDireccionPostal = empresa.getElementsByTagName("empresaDireccionPostal").item(0)
                    .getTextContent();
            String empresaDireccionWeb = empresa.getElementsByTagName("empresaDireccionWeb").item(0).getTextContent();
            String empresaTelefono = empresa.getElementsByTagName("empresaTelefono").item(0).getTextContent();
            Empresa empresaModel = new Empresa(empresaNombre, empresaCif, empresaDireccionPostal, empresaDireccionWeb,
                    empresaTelefono);
            lstEmpresa.add(empresaModel);
        }
        return lstEmpresa;
    }

    public static ArrayList<Particular> insertIntoParticular(NodeList nodeList) {
        ArrayList<Particular> lstParticular = new ArrayList<>();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Element empresa = (Element) nodeList.item(i);
            String particularNombre = empresa.getElementsByTagName("particularNombre").item(0).getTextContent();
            String particularApellido = empresa.getElementsByTagName("particularApellido").item(0).getTextContent();
            String particularTelefono = empresa.getElementsByTagName("particularTelefono").item(0)
                    .getTextContent();
            String particularDireccion = empresa.getElementsByTagName("particularDireccion").item(0).getTextContent();
            String firma = empresa.getElementsByTagName("firma").item(0).getTextContent();
            Particular particularModel = new Particular(particularNombre, particularApellido, particularTelefono,
                    particularDireccion, firma);
            lstParticular.add(particularModel);
        }
        return lstParticular;
    }
}
