package Action;

import com.google.gson.Gson;

import DAO.ValoracionDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Producto;
import model.Usuario;
import model.Valoracion;

public class ValoracionAction {
    Gson gson = new Gson();

    public String execute(String action, HttpServletRequest req, HttpServletResponse resp) {
        String json = "";
        switch (action) {
            case "ADD":
                json = add(req, resp);
                break;
        }
        return json;
    }

    public String add(HttpServletRequest req, HttpServletResponse resp) {
        // RECOGER EL USUARIO QUE VA A VALORAR
        String usuarioId = req.getParameter("USUARIOID");
        int usuarioIdInt = Integer.parseInt(usuarioId);
        Usuario usuarioObj = new Usuario(usuarioIdInt);
        // RECOGER LAS ESTRELLAS
        String estrella = req.getParameter("ESTRELLA");
        int estrellaInt = Integer.parseInt(estrella);
        // RECOGER EL COMENTARIO
        String comentario = req.getParameter("COMENTARIO");
        // RECOGER EL USUARIO VALORADO
        String usuarioValoradoId = req.getParameter("VALORADOID");
        int usuarioValoradoInt = Integer.parseInt(usuarioValoradoId);
        Usuario usuarioValorado = new Usuario(usuarioValoradoInt);
        // RECOGER EL PRODUCTO
        String productoId = req.getParameter("PRODUCTOID");
        Integer productoIdInt = Integer.parseInt(productoId);
        Producto producto = new Producto(productoIdInt);
        // CREAR EL OBJETO Y LLAMAR AL DAO
        Valoracion valoracion = new Valoracion(usuarioObj, estrellaInt, comentario, usuarioValorado, producto);
        return gson.toJson(new ValoracionDAO().add(valoracion));

    }

}
