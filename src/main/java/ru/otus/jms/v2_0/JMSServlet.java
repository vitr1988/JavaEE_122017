package ru.otus.jms.v2_0;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/jms")
public class JMSServlet extends HttpServlet {

    @Inject
    @JMSConnectionFactory("jms/ConnectionFactory")
    private JMSContext context;

    @Resource(lookup = "jms/Queue")
    private Queue dataQueue;

    public void sendMessageJavaEE7(String body) {
        context.createProducer().send(dataQueue, body);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        sendMessageJavaEE7("Hello World");

        response.setContentType("text/html");
        try(PrintWriter pw = response.getWriter()){
            pw.println("OK");
        }
    }
}
