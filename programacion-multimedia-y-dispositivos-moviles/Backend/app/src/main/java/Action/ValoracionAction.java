package Action;

import com.google.gson.Gson;

import DAO.ValoracionDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Valoracion;

public class ValoracionAction implements IAction {
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'find'");
    }

    @Override
    public String findAll(HttpServletRequest req, HttpServletResponse resp) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
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
        String estrellas = req.getParameter("ESTRELLA");
        int estrellaInt = Integer.parseInt(estrellas);
        String usuarioId = req.getParameter("USUARIOID");
        int usuarioIdInt = Integer.parseInt(usuarioId);
        String usuarioValoradoId = req.getParameter("USUARIOVALORADOID");
        int usuarioValoradoIdInt = Integer.parseInt(usuarioValoradoId);
        String comentario = req.getParameter("COMENTARIO");
        Valoracion valoracion;
        if (comentario.equals("")) {
            valoracion = new Valoracion(usuarioIdInt, estrellaInt, comentario, usuarioValoradoIdInt);

        } else {
            valoracion = new Valoracion(usuarioIdInt, estrellaInt, usuarioValoradoIdInt);
        }
        return gson.toJson(new ValoracionDAO().add(valoracion));

    }

}
