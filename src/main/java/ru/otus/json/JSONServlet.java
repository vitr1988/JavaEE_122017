package ru.otus.json;

import ru.otus.json.model.User;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "JSONServlet", urlPatterns = "/json")
public class JSONServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = new User();
        user.setLogin("test");
        user.setPassword(new char[]{'t', 'e', 's', 't'});
        // Create Jsonb and serialize
        Jsonb jsonb = JsonbBuilder.create();
        String result = jsonb.toJson(user);

        // Serialize back
        try(PrintWriter pw = response.getWriter()){
            pw.println(jsonb.toJson(result));
        }


    }
}
