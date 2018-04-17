package ru.otus.cdi;

import ru.otus.cdi.event.MessageEvent;
import ru.otus.cdi.qualifier.LanguageEnum;
import ru.otus.cdi.qualifier.MessageType;
import ru.otus.cdi.qualifier.Time;
import sun.plugin2.message.EventMessage;

import javax.enterprise.event.Event;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.enterprise.inject.spi.CDI;
import javax.inject.Inject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "MessageCDIServlet", urlPatterns = "/messagecdi")
public class MessageCDIServlet extends HttpServlet {

    @Inject
//    @MessageType(LanguageEnum.RUSSIAN)
    private Message message; //= CDI.current().select(Message.class).get();

    @Time
    @Inject
    private String currentDateAsString;

    @Inject
    Event<MessageEvent> event;

//    @Inject
//    public MessageCDIServlet(Message message){
//        this.message = message;
//    }
//
//    @Inject
//    public void setMessage(Message message){
//        this.message = message;
//    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=" + StandardCharsets.UTF_8.name());
        try (PrintWriter out = response.getWriter()) {
            String text = message.get();
            out.println(text);
            out.println("Current Date: " + currentDateAsString);
            event.fire(new MessageEvent(text));
        }
    }
}
