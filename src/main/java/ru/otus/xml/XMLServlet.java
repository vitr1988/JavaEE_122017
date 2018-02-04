package ru.otus.xml;

import ru.otus.resource.XmlBean;

import javax.annotation.Resource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "XMLServlet", urlPatterns = "/xml")
public class XMLServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try(PrintWriter writer = response.getWriter()){
            Customer c = new Customer();
            c.setAge(25);
            c.setId(123);
            c.setSalary(100000);
            c.setName("Ivanov Ivan");

            writer.println("There can be xml bean, but this is Tomcat specific feature");
        }
    }
}
