package ru.otus.jaxws;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@WebService(serviceName = "DateService", name = "DateProvider")
public class DateWebService implements DateProvider {

    @WebMethod
    public String getCurrentDate() {
        return DateTimeFormatter.ofPattern("dd.MM.yyyy").format(LocalDateTime.now());
    }
}
