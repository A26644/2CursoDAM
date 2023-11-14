package Action;

import com.google.gson.Gson;

import DAO.UsuarioDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UsuarioAction implements IAction {
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
            case "FINDMOST":
                json = findMost(req, resp);
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'find'");
    }

    @Override
    public String findAll(HttpServletRequest req, HttpServletResponse resp) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    public String findMost(HttpServletRequest req, HttpServletResponse resp) {
        return gson.toJson(new UsuarioDAO().findMost());

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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

}
