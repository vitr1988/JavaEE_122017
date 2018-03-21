package ru.otus.jaxws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService
public class SoapCalculator {

    /**
     * @param number1      first argument
     * @param number2       second argument
     * @return The sum of number1 and number2.
     */
    @WebMethod
    @WebResult
    public int addNumbers(
            @WebParam int number1,
            @WebParam int number2){
        return number1 + number2;
    }
}
