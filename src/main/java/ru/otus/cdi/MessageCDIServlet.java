package ru.otus.cdi;

import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.enterprise.inject.spi.CDI;
import javax.inject.Inject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "MessageCDIServlet", urlPatterns = "/messagecdi")
public class MessageCDIServlet extends HttpServlet {

//    @Any
    @Inject
    private /*Instance<*/Message/*>*/ message; //= CDI.current().select(Message.class).get();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        try (PrintWriter out = response.getWriter()) {
            out.println(message/*.get()*/.get());
        }
    }
}
