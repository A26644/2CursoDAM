package Action;

import java.sql.Date;
import java.time.LocalDate;

import com.google.gson.Gson;

import DAO.ProductoDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Producto;

public class ProductAction implements IAction {
    Gson gson = new Gson();

    @Override
    public String execute(String action, HttpServletRequest req, HttpServletResponse resp) {
        String json = "";
        switch (action) {
            case "FIND":
                json = find(req, resp);
                break;
            case "FINDALL":
                json = findAll(req, resp);
                break;
            case "UPDATE":
                json = update(req, resp);
                break;
            case "DELETE":
                json = delete(req, resp);
                break;
            case "ADD":
                json = add(req, resp);
                break;
        }
        return json;

    }

    @Override
    public String find(HttpServletRequest req, HttpServletResponse resp) {
        String id = req.getParameter("ID");
        int idInt = Integer.parseInt(id);
        return gson.toJson(new ProductoDAO().find(idInt));
    }

    @Override
    public String findAll(HttpServletRequest req, HttpServletResponse resp) {
        return gson.toJson(new ProductoDAO().findAll());
    }

    @Override
    public String delete(HttpServletRequest req, HttpServletResponse resp) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public String update(HttpServletRequest req, HttpServletResponse resp) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public String add(HttpServletRequest req, HttpServletResponse resp) {
        // RECOGER LOS PARAMETROS
        String usuarioId = req.getParameter("USUARIOID");
        int usuarioIdInt = Integer.parseInt(usuarioId);
        String marca = req.getParameter("MARCA");
        String precio = req.getParameter("PRECIO");
        double precioDouble = Double.parseDouble(precio);
        LocalDate currentDate = LocalDate.now();
        Date sqlDate = Date.valueOf(currentDate);
        System.out.println(sqlDate);
        String descripcion = req.getParameter("DESCRIPCION");
        String nombre = req.getParameter("NOMBRE");
        String imagen = req.getParameter("IMAGEN");
        String estado = req.getParameter("ESTADO");
        String color = req.getParameter("COLOR");
        // CREAR EL OBJETO
        Producto producto = new Producto(usuarioIdInt, marca, precioDouble, sqlDate, descripcion, nombre, imagen,
                estado, color);
        return gson.toJson(new ProductoDAO().add(producto));

    }

}
