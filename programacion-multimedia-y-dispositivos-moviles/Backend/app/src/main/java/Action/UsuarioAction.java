package Action;

import com.google.gson.Gson;

import DAO.UsuarioDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Usuario;

public class UsuarioAction {
    Gson gson = new Gson();

    public String execute(String action, HttpServletRequest req, HttpServletResponse resp) {
        String json = "";
        switch (action) {
            case "FINDMOST":
                json = findMost(req, resp);
                break;

            case "LOGIN":
                json = login(req, resp);
                break;
            case "FINDMOSTSTAR":
                json = findMostStar(req, resp);
                break;
        }
        return json;
    }

    public String login(HttpServletRequest req, HttpServletResponse resp) {
        String email = req.getParameter("EMAIL");
        String password = req.getParameter("PASS");
        Usuario usuario = new Usuario(email, password);
        return gson.toJson(new UsuarioDAO().login(usuario));

    }

    public String findMost(HttpServletRequest req, HttpServletResponse resp) {
        return gson.toJson(new UsuarioDAO().findMost());

    }

    public String findMostStar(HttpServletRequest req, HttpServletResponse resp) {
        return gson.toJson(new UsuarioDAO().findMostStar());
    }

}
