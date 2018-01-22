package ru.otus.html;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/jsoup")
public class JsoupServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Document doc;
        response.setContentType("text/html; charset=UTF8");
        try (PrintWriter pw = response.getWriter()) {
//            doc = Jsoup.connect("http://google.com/").get();
            doc = Jsoup.connect(request.getScheme() + "://"
                    + request.getServerName() + ":" + request.getServerPort()
                    + request.getContextPath()
                    + "/page.html").get();
            pw.println(doc.getElementById("news1").text() + "<br/>");
            pw.println(doc.getElementById("news1").getElementsByTag("h3").first().text());
//            pw.println(doc.title());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
