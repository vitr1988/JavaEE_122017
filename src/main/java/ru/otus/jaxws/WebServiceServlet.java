package ru.otus.jaxws;

import com.sun.org.apache.xml.internal.resolver.Catalog;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "WebServiceServlet")
public class WebServiceServlet extends HttpServlet {

    @WebServiceRef(type=DateWebService.class)
    private DateWebService service;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

//        //service instance injected...
//        Catalog port = service.getDatePort();
//        Date currentDate = port.getCurrentDate();
//        try (PrintWriter out = response.getWriter()) {
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>WebServiceRef Test</title>");
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Title= " + currentDate + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
    }

}
