package Action;

import java.sql.Date;
import java.time.LocalDate;

import com.google.gson.Gson;

import DAO.ProductoDAO;
import DAO.UsuarioDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Producto;

public class ProductAction {
    Gson gson = new Gson();

    public String execute(String action, HttpServletRequest req, HttpServletResponse resp) {
        String json = "";
        switch (action) {
            case "ADD":
                json = add(req, resp);
                break;
            case "FIND":
                json = find(req, resp);
                break;
            case "FINDMOST":
                json = findMost(req, resp);
                break;
            case "FINDALL":
                json = findAll(req, resp);
                break;
            case "FINDFILTER":
                json = findFilter(req, resp);
                break;
        }
        return json;

    }

    public String findFilter(HttpServletRequest req, HttpServletResponse resp) {
        String filterNumbers = req.getParameter("FILTER");
        String filterName = req.getParameter("FILTERNAME");
        String usuarioId = req.getParameter("USUARIOID");
        Integer usuarioIdInt = Integer.parseInt(usuarioId);
        String stringArray[] = new String[] { filterNumbers, filterName };
        return gson.toJson(new ProductoDAO().findFilter(stringArray, usuarioIdInt));
    }

    public String findAll(HttpServletRequest req, HttpServletResponse resp) {
        String userId = req.getParameter("USUARIOID");
        Integer userIdInt = Integer.parseInt(userId);
        return gson.toJson(new ProductoDAO().findAll(userIdInt));
    }

    public String add(HttpServletRequest req, HttpServletResponse resp) {
        // RECOGER LOS PARAMETROS
        String usuarioId = req.getParameter("USUARIOID");
        int usuarioIdInt = Integer.parseInt(usuarioId);
        String marca = req.getParameter("MARCA");
        String precio = req.getParameter("PRECIO");
        double precioDouble = Double.parseDouble(precio);
        LocalDate currentDate = LocalDate.now();
        Date sqlDate = Date.valueOf(currentDate);
        String descripcion = req.getParameter("DESCRIPCION");
        String nombre = req.getParameter("NOMBRE");
        String imagen = req.getParameter("IMAGEN");
        String estado = req.getParameter("ESTADO");
        String color = req.getParameter("COLOR");
        // CREAR EL OBJETO
        Producto producto = new Producto(usuarioIdInt, new UsuarioDAO().find(usuarioIdInt), marca, precioDouble,
                sqlDate, descripcion, nombre, imagen, estado, color);

        return gson.toJson(new ProductoDAO().add(producto));

    }

    public String find(HttpServletRequest req, HttpServletResponse resp) {
        String userId = req.getParameter("USUARIOID");
        Integer userIdInt = Integer.parseInt(userId);
        return gson.toJson(new ProductoDAO().find(userIdInt));
    }

    public String findMost(HttpServletRequest req, HttpServletResponse resp) {
        return "";
    }

}
