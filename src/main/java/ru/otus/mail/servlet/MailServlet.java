package ru.otus.mail.servlet;

import ru.otus.mail.MailConfig;
import ru.otus.mail.bean.EmailBean;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "MailServlet", urlPatterns = "/mail")
public class MailServlet extends HttpServlet {

    @Inject
    private EmailBean emailBean;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain");
        // compose message
        try (PrintWriter pw = response.getWriter()){
            emailBean.sendEmail(MailConfig.RECEIVE_EMAILS, "New Subject", "This is body of test message");
            pw.println("Message sent successfully");
        } catch (MessagingException e) {
            throw new ServletException(e);
        }
    }
}
