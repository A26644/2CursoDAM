package Controller;

import java.io.IOException;

import Action.DireccionAction;
import Action.FavoritoAction;
import Action.ProductAction;
import Action.VentaAction;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        doGeneral(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        doGeneral(req, resp);
    }

    public void doGeneral(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String json = "";
        String action = req.getParameter("ACTION");
        String[] actionSplitted = action.split("\\.");
        switch (actionSplitted[0]) {
            case "PRODUCTO":
                json = new ProductAction().execute(actionSplitted[1], req, resp);
                break;
            case "FAVORITO":
                json = new FavoritoAction().execute(actionSplitted[1], req, resp);
                break;
            case "DIRECCION":
                json = new DireccionAction().execute(actionSplitted[1], req, resp);
                break;
            case "VENTA":
                json = new VentaAction().execute(actionSplitted[1], req, resp);
                break;
        }
        resp.getWriter().write(json);
    }

}
