package ru.otus.resource;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class XmlBean {

    private Path xmlPath;

    public Path getXmlPath() {
        return xmlPath;
    }

    public void setXmlPath(Path xmlPath) {
        this.xmlPath = xmlPath;
    }

    public void setXmlPath(String xmlPath) {
        this.xmlPath = Paths.get(xmlPath);
    }

    public void process(Object persistObject) {
        try{
            //creating the JAXB context
            JAXBContext jContext = JAXBContext.newInstance(persistObject.getClass());
            //creating the marshaller object
            Marshaller marshallObj = jContext.createMarshaller();
            //setting the property to show xml format output
            marshallObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            //calling the marshall method
            marshallObj.marshal(persistObject, Files.newOutputStream(xmlPath));
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
