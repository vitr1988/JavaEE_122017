package ru.otus.jaxws.weather;

import javax.annotation.Resource;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.*;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.http.HTTPBinding;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;

@WebServiceProvider
@ServiceMode(value = Service.Mode.MESSAGE)
@BindingType(value = HTTPBinding.HTTP_BINDING)
public class RESTfulWeather implements Provider<Source> {

    @Resource
    protected WebServiceContext wsContext;

    @Override
    public Source invoke(Source request) {
        MessageContext msg_cxt = wsContext.getMessageContext();
        String httpMethod = (String) msg_cxt.get(MessageContext.HTTP_REQUEST_METHOD);
        if (httpMethod.equalsIgnoreCase("GET")) {
            return doGet(msg_cxt);
        }
        return null;
    }

    private Source doGet(MessageContext msg_cxt) {
        String query_string = (String) msg_cxt.get(MessageContext.QUERY_STRING);
        StringBuffer text = new StringBuffer("");
        String city = query_string.split("=")[1];
        try {
            URL url = new URL("http://api.openweathermap.org/data/2.5/weather?appid=3d58903046050728d7b36ce11b3ce32d&q=" + city);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            BufferedReader bReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line = null;

            while ((line = bReader.readLine()) != null) {
                text=text.append(line);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new StreamSource( new StringReader(text.toString()) );

    }

}
