package ru.otus.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.otus.json.model.Car;
import ru.otus.json.model.Owner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "GSONServlet", urlPatterns = "/gson")
public class GSONServlet extends HttpServlet {

    private static final Gson JSON = new GsonBuilder().setPrettyPrinting().create();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Content-type", "application/json");
        Car car = new Car("Lada", "Vesta", 600000);
        Owner owner = new Owner();
        owner.setAge(30);
        owner.setFio("Ivanov Ivan Ivanovich");
        car.setPerson(owner);
        try (PrintWriter pw = response.getWriter()) {
            String json = JSON.toJson(car);
            pw.println(json);
            System.out.println(json);
        }

    }
}
