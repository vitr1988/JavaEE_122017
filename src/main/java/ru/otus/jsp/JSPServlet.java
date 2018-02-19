package ru.otus.jsp;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

@WebServlet(name = "JSPServlet")
public class JSPServlet extends HttpServlet {

    int field = 365;
    String getFormattedDate() {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd.MM.yyyy hh:mm:ss");
        return f.format(LocalDateTime.now());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext appplication = getServletContext();
        HttpSession session = request.getSession(false);
        boolean isNotAuthorized = session == null;

        ServletConfig config = getServletConfig();

        try (PrintWriter pw = response.getWriter()) {
            pw.write("<head>\n" +
                    "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
                    "    <!-- Hello World -->\n" +
                    "    <title>Добро пожаловать, JSP!</title>\n" +
                    "</head>");

            pw.write("<i>Сегодня ");
            pw.write(getFormattedDate());
            pw.write("</i>");
        }
        //blabla..
        String text = "Hello World";
        if (new Random().nextBoolean()) {
            field++;
        }
        else {
            return;
        }
        //blabla..
    }
}
