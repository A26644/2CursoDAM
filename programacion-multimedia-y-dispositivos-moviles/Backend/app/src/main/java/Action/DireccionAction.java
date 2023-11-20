package Action;

import com.google.gson.Gson;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DireccionAction {
    Gson gson = new Gson();

    public String execute(String action, HttpServletRequest req, HttpServletResponse resp) {
        String json = "";
        switch (action) {

        }
        return json;
    }

}
