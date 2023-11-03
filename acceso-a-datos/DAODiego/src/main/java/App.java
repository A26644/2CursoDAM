
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

import DAO.EmpresaDAO;
import DAO.ParticularDAO;
import JavaXML.Inserts;
import JavaXML.XMLMapper;
import model.Empresa;
import model.Particular;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(
                "Elige que quieres hace, leer o escribir un XML\n1. Insertar a BD desde XML\n2. Insertar a XML desde BD");
        int eleccion = scanner.nextInt();
        if (eleccion == 1) {
            try {
                File xmlFile = new File("src/main/java/xml/archivo.xml");
                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

                DocumentBuilder builder = factory.newDocumentBuilder();
                Document document = builder.parse(xmlFile);
                System.out.println("Elige que tabla deseas insertar a BD\n1. Empresa\n2. Particulares");
                int eleccion2 = scanner.nextInt();
                switch (eleccion2) {
                    case 1:
                        ArrayList<Empresa> lstEmpresa = Inserts
                                .insertIntoEmpresa(document.getElementsByTagName("model.Empresa"));
                        for (Empresa empresa : lstEmpresa) {
                            new EmpresaDAO().add(empresa);
                        }
                        break;
                    case 2:
                        ArrayList<Particular> lstParticular = Inserts
                                .insertIntoParticular(document.getElementsByTagName("model.Particular"));
                        for (Particular particular : lstParticular) {
                            new ParticularDAO().add(particular);
                        }
                        break;
                    default:
                        System.out.println("Opcion no valida");
                        break;
                }
            } catch (Exception e) {
                System.out.println(e);
            }

        } else {
            System.out.println("Elige que tabla quieres exportar a XML\n1. Empresas\n2. Particulares");
            String xml = "";
            int tabla = scanner.nextInt();
            switch (tabla) {
                case 1:
                    ArrayList<Empresa> lstEmpresa = new EmpresaDAO().findAll();
                    xml = XMLMapper.transformar("Empresas", lstEmpresa);
                    XMLMapper.exportarArchivo(xml, "ListaDeEmpresas");
                    break;
                case 2:
                    ArrayList<Particular> lstParticular = new ParticularDAO().findAll();
                    xml = XMLMapper.transformar("Empresas", lstParticular);
                    XMLMapper.exportarArchivo(xml, "ListaDeParticulares");
                    break;
                default:
                    System.out.println("No es valido");
                    break;
            }
            scanner.close();
            System.out.println("Fin del problema");
        }

    }
}
