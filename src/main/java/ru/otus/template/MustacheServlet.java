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
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@WebServlet(name = "MustacheServlet", urlPatterns = "/mustache")
public class MustacheServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MustacheFactory mf = new DefaultMustacheFactory();
        BufferedReader reader = new BufferedReader(new InputStreamReader(getServletContext().getResourceAsStream("/WEB-INF/classes/todo.mustache")));
        Mustache m = mf.compile(reader, null);

        String sysVariable = System.getenv("MARKER_NAME");

        response.setContentType("text/html;charset=UTF-8");
        try(PrintWriter writer = response.getWriter()) {
            Map<String, Object> context = new HashMap<>();
//            List<ToDo> todo = Arrays.asList(
//                new ToDo("Ivanov Vitalii", new Date(), "Hello World!")
//                , new ToDo("Sidorov Petr", new Date("04/12/2017"), "Hi World!")
//            );
//            context.put("todos", todo);

//            m.execute(writer, new ToDo("Ivanov Vitalii", new Date(), "Hello World!")).flush();
            m.execute(writer, context).flush();
        }
        finally {
            reader.close();
        }
    }
}
