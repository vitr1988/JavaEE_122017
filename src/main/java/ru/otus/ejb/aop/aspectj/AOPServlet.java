package ru.otus.ejb.aop.aspectj;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/aop")
public class AOPServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        try (PrintWriter out = resp.getWriter()) {
            Account acc = new Account();
            out.println("Account before withdraw: " + acc.balance + "<br/>");
            acc.withdraw(10);
            out.println("Account after withdraw: " + acc.balance + "");
        }
    }
}
