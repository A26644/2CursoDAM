package Action;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import DAO.VentaDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class VentaAction {
    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();

    public String execute(String action, HttpServletRequest req, HttpServletResponse resp) {
        String json = "";
        switch (action) {
            case "FINDONSALE":
                json = findOnSale(req, resp);
                break;
        }
        return json;
    }

    public String findOnSale(HttpServletRequest req, HttpServletResponse resp) {
        String id = req.getParameter("USUARIOID");
        Integer idInt = Integer.parseInt(id);
        return gson.toJson(new VentaDAO().findOnSale(idInt));

    }

}
