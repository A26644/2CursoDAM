package Action;

import com.google.gson.Gson;

import DAO.DireccionDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DireccionAction {
    Gson gson = new Gson();

    public String execute(String action, HttpServletRequest req, HttpServletResponse resp) {
        String json = "";
        switch (action) {
            case "FIND":
                json = find(req, resp);
                break;

        }
        return json;
    }

    public String find(HttpServletRequest req, HttpServletResponse resp) {
        String userId = req.getParameter("USUARIOID");
        Integer userIdInt = Integer.parseInt(userId);
        return gson.toJson(new DireccionDAO().find(userIdInt));

    }

}
