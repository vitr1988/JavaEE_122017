package ru.otus.xml;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.IOException;
import java.net.URL;

public class Main {

    //TODO: перенести в ObjectResourceFactory
    public static void main(String[] args) {
        try {
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            URL schemaFile = Main.class.getResource("/customer.xsd");

            Schema schema = factory.newSchema(schemaFile);
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(Main.class.getResourceAsStream("/customer.xml")));

        } catch (IOException | SAXException e) {
            System.out.println("Exception: "+ e.getMessage());

        }
        System.out.println("All done!");
    }
}
