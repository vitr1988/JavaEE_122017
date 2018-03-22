package ru.otus.jaxws.weather;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherClient {
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        // GET requests
        URL url = new URL("http://127.0.0.1:8700/weather?city=moscow");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();

        String xml = "";
        BufferedReader reader =	new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String next = null;
        while ((next = reader.readLine()) != null)
            xml += next;

        SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
        SaxParserHandler handler=new SaxParserHandler();
        parser.parse(new ByteArrayInputStream(xml.getBytes()),handler);
        System.out.println("-------------------------------------------------------------------");
        System.out.println(handler.city+" weather update on "+handler.lastUpdate);
        System.out.println("-------------------------------------------------------------------");
        System.out.println("City : "+handler.city);
        System.out.println("Latitude : "+handler.latitude);
        System.out.println("Longitude : "+handler.longitude);
        System.out.println("Mininum Temperature (Celsius) : "+handler.minTemperature);
        System.out.println("Maximum Temperature (Celsius) : "+handler.maxTemperature);
        System.out.println("Wind : "+handler.wind);
        System.out.println("Clouds : "+handler.clouds);
    }
}

class SaxParserHandler extends DefaultHandler {
    String city;
    String latitude;
    String longitude;
    float minTemperature;
    float maxTemperature;
    String wind;
    String clouds;
    String lastUpdate;

    public void startElement(String namespaceURI,String localName,String qname,Attributes attributes){

        if(qname.equals("city")){
            city=attributes.getValue("name");
        }else if(qname.equals("coord")){
            latitude=attributes.getValue("lat");
            longitude=attributes.getValue("lon");
        }
        else if(qname.equals("temperature")){
            String minKelvin=attributes.getValue("min");
            minTemperature=Math.round(Float.parseFloat(minKelvin)) - 272;
            String maxKelvin=attributes.getValue("max");
            maxTemperature= Math.round(Float.parseFloat(maxKelvin)) - 272;
        }
        else if(qname.equals("speed")){
            wind=attributes.getValue("name");
        }
        else if(qname.equals("clouds")){
            clouds=attributes.getValue("name");
        }
        else if(qname.equals("lastupdate")){
            lastUpdate=attributes.getValue("value").split("T")[0];
        }
    }

}
