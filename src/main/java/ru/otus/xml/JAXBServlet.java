package ru.otus.xml;

import ru.otus.xml.model.TestData;
import ru.otus.xml.model.TestDataWrapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

@WebServlet("/jaxb")
public class JAXBServlet extends HttpServlet {

    public static final String TEST_DATA_FILE_LOCATION = "testDataFileLocation";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TestDataWrapper data = new TestDataWrapper(Arrays.asList(
                new TestData("Ivanov Ivan", 18)
                , new TestData("Petrov Petr", 25)
                , new TestData("Sidorov Sidr", 36)));

        try(PrintWriter pw = response.getWriter()) {
            JAXBContext context = JAXBContext.newInstance(data.getClass());
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            String file = getServletContext().getInitParameter(TEST_DATA_FILE_LOCATION);
            pw.println(new URI(file).toString());
            m.marshal(data, Paths.get(new URI(file)).toFile());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
