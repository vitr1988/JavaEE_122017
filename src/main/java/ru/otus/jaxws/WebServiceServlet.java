package ru.otus.jaxws;

import ru.otus.jaxws.client.DateProvider;
import ru.otus.jaxws.client.DateWebService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "WebServiceServlet", urlPatterns = "/dateWebService")
public class WebServiceServlet extends HttpServlet {

    //service instance injected...
    @WebServiceRef
    private DateWebService service;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        DateProvider port = service.getDateProviderPort();
        String currentDate = port.getCurrentDate();
        try (PrintWriter out = response.getWriter()) {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>WebServiceRef Test</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Title= " + currentDate + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
