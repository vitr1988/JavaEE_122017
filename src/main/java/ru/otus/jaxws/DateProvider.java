package ru.otus.jaxws;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.util.Date;

@WebService
public interface DateProvider {
    @WebMethod
    @WebResult(name="currentDate")
    String getCurrentDate();
}
