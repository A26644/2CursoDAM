package Action;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface IAction {
    public String execute(String action, HttpServletRequest req, HttpServletResponse resp);

    public String find(HttpServletRequest req, HttpServletResponse resp);

    public String findAll(HttpServletRequest req, HttpServletResponse resp);

    public String delete(HttpServletRequest req, HttpServletResponse resp);

    public String update(HttpServletRequest req, HttpServletResponse resp);

    public String add(HttpServletRequest req, HttpServletResponse resp);

}
