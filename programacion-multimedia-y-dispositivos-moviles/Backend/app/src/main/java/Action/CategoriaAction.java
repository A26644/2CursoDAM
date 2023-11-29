package Action;

import com.google.gson.Gson;

import DAO.CategoriaDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CategoriaAction {
    Gson gson = new Gson();

    public String execute(String action, HttpServletRequest req, HttpServletResponse resp) {
        String json = "";
        switch (action) {
            case "FINDALL":
                json = findAll(req, resp);
                break;

        }
        return json;
    }

    public String findAll(HttpServletRequest req, HttpServletResponse resp) {
        return gson.toJson(new CategoriaDAO().findAll());
    }
}
