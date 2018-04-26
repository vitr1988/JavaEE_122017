package ru.otus.log;

import org.apache.log4j.Logger;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ResourceBundle;

@WebServlet("/log")
public class LoggerServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(LoggerServlet.class);

//    @Inject
//    private Logger logger;

    private ResourceBundle resource = ResourceBundle.getBundle("MessageResources");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Http method get had begun");
        resp.setContentType("text/plain;charset=UTF-8");
        try (PrintWriter pw = resp.getWriter()) {
            pw.println("Logging fixed");
            pw.println(resource.getString("main.message"));
        }
        catch(Exception e){
            logger.error(e.getLocalizedMessage());
        }
        logger.info("Http method get had finished");
    }
}
