package ru.otus.template;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;
import com.github.mustachejava.codes.DefaultMustache;
import org.apache.commons.io.IOUtils;
import ru.otus.template.model.ToDo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;
import java.util.stream.Collectors;

@WebServlet(name = "MustacheServlet", urlPatterns = "/mustache")
public class MustacheServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MustacheFactory mf = new DefaultMustacheFactory();
        BufferedReader reader = new BufferedReader(new InputStreamReader(getServletContext().getResourceAsStream("/WEB-INF/classes/todo.mustache")));
        Mustache m = mf.compile(reader, null);

        response.setContentType("text/html;charset=UTF");
        try(PrintWriter writer = response.getWriter()) {
            m.execute(writer, new ToDo("Ivanov Vitalii", new Date(), "Hello World!")).flush();
        }
        finally {
            reader.close();
        }
    }
}
