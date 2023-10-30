
import java.util.ArrayList;

import DAO.EmpresaDAO;
import model.Empresa;

public class App {
    public static void main(String[] args) {

        ArrayList<Empresa> lstEmpresa = new EmpresaDAO().findAll();
        String xml = XMLMapper.transformar("Empresas", lstEmpresa);
        XMLMapper.exportarArchivo(xml, "./archivoExportado");
    }
}
