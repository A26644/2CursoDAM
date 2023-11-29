package Action;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import DAO.VentaDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Direccion;
import model.Producto;
import model.Usuario;
import model.Venta;

public class VentaAction {
    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();

    public String execute(String action, HttpServletRequest req, HttpServletResponse resp) {
        String json = "";
        switch (action) {
            case "FINDONSALE":
                json = findOnSale(req, resp);
                break;
            case "SELL":
                json = sell(req, resp);
                break;
            case "FIND":
                json = find(req, resp);
                break;
        }
        return json;
    }

    public String sell(HttpServletRequest req, HttpServletResponse resp) {
        String userId = req.getParameter("COMPRADORID");
        String saleUserId = req.getParameter("VENDEDORID");
        String direccionId = req.getParameter("DIRECCIONID");
        String productoId = req.getParameter("PRODUCTOID");

        Integer direccionIdInt = Integer.parseInt(direccionId);
        Integer userIdInt = Integer.parseInt(userId);
        Integer saleUserIdInt = Integer.parseInt(saleUserId);
        Integer productoIdInt = Integer.parseInt(productoId);
        Venta venta = new Venta(new Usuario(userIdInt), new Usuario(saleUserIdInt), new Direccion(direccionIdInt),
                new Producto(productoIdInt));
        return gson.toJson(new VentaDAO().sell(venta));
    }

    public String findOnSale(HttpServletRequest req, HttpServletResponse resp) {
        String id = req.getParameter("USUARIOID");
        Integer idInt = Integer.parseInt(id);
        return gson.toJson(new VentaDAO().findOnSale(idInt));

    }

    public String find(HttpServletRequest req, HttpServletResponse resp) {
        String userId = req.getParameter("USUARIOID");
        Integer userIdInt = Integer.parseInt(userId);
        return gson.toJson(new VentaDAO().find(userIdInt));
    }

}
