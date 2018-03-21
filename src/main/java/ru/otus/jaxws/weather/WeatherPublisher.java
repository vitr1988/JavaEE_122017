package ru.otus.jaxws.weather;

import javax.xml.ws.Endpoint;

public class WeatherPublisher {
    public static void main(String[] args) {
        System.out.println("Publishing Weather Service");
        Endpoint.publish("http://127.0.0.1:8700/weather",new RESTfulWeather());
    }
}
