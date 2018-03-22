package ru.otus.jaxws.calculator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CalculatorServlet", urlPatterns = "/calculator")
public class CalculatorServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        SoapCalculatorService service = new SoapCalculatorService();
        SoapCalculator soapCalculatorPort = service.getSoapCalculatorPort();

        response.setContentType("text/html");
        try (PrintWriter pw = response.getWriter()) {
            pw.println(soapCalculatorPort.addNumbers(20, 25));
        }
    }
}
