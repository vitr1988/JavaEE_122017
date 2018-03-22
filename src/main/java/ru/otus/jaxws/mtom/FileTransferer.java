package ru.otus.jaxws.mtom;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Objects;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.BindingType;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.soap.MTOM;
import javax.xml.ws.soap.SOAPBinding;

/**
 * A web service endpoint implementation that demonstrates the usage of
 * MTOM (Message Transmission Optimization Mechanism).
 */
@WebService
//@BindingType(value = SOAPBinding.SOAP11HTTP_MTOM_BINDING)
//@BindingType(value = SOAPBinding.SOAP12HTTP_MTOM_BINDING)
@MTOM(enabled = true, threshold = 10240/*in bytes*/)
public class FileTransferer {

    @Resource
    private WebServiceContext wsCtxt;

    private File serverPath;

    private String prepare() {
        if (serverPath == null) {
            // Acquire the message context
            MessageContext mContext = wsCtxt.getMessageContext();
            // Acquire the properties
            ServletContext sContext = (ServletContext)mContext.get(MessageContext.SERVLET_CONTEXT);
            String path = sContext.getInitParameter("testDataFileLocation");
            if (Objects.nonNull(path)) {
                try {
                    serverPath = new File(new URL(path).toURI());
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        }
        return serverPath.getParent();
    }

    @WebMethod
    public void upload(String fileName, byte[] imageBytes) throws IOException {
        String filePath = prepare() + "/" + fileName; // server location
        File file = new File(filePath);
        if (!file.exists()) {
            file.createNewFile();
        }
        try (OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(filePath))) {
            System.out.println("Received file: " + filePath);
            outputStream.write(imageBytes);
        } catch (IOException ex) {
            System.err.println(ex);
            throw new WebServiceException(ex);
        }
    }

    @WebMethod
    public byte[] download(String fileName) {
        String filePath = prepare() + "/" + fileName;
        System.out.println("Sending file: " + filePath);

        File file = new File(filePath);
        try (InputStream inputStream = new BufferedInputStream(new FileInputStream(file))) {
            byte[] fileBytes = new byte[(int) file.length()];
            inputStream.read(fileBytes);
            return fileBytes;
        } catch (IOException ex) {
            System.err.println(ex);
            throw new WebServiceException(ex);
        }
    }
}
