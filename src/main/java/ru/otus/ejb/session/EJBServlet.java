package ru.otus.ejb.session;

//import ru.otus.ejb.session.statefull.EmployeeManageable;
//import ru.otus.ejb.session.stateless.SimpleBean;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "EJBServlet", urlPatterns = "/ejb")
public class EJBServlet extends HttpServlet {

//    @EJB
//    SimpleBean bean;

//    @EJB
//    EmployeeManageable dataBean;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        try(PrintWriter pw = response.getWriter()) {
//            pw.println(bean.sayHello(dataBean.getEmployeeName(Long.valueOf(request.getParameter("id")))));
        }
    }
}
