package ru.otus.servlet;

import com.google.gwt.user.client.ui.ImageBundle;

import javax.annotation.Resource;
import javax.annotation.Resources;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

@WebServlet(name = "InitializeServlet", urlPatterns = "/init", loadOnStartup = 1)
public class InitializeServlet extends HttpServlet {

    public void init(ServletConfig sc) {
        String hello = "Hello World";
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.getParameter();
        if (request.getInputStream() == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
