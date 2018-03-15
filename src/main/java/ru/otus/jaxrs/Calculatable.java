package ru.otus.jaxrs;

import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

public interface Calculatable {

    Response calcSqrt(int value);
    Response calcAddTwoValues(double value1, double value2);
    Response calcSubTwoValues(double value1, double value2);
    Response calcDivTwoValues(double value1, double value2);
}
