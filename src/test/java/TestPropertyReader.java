import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.thoughtworks.xstream.XStream;
import dto.ValCurs;
import dto.Valute;
import my.first.http.program.PropertyReader;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;


import org.apache.http.HttpResponse;

import javax.xml.bind.SchemaOutputResolver;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestPropertyReader {
    public static final String EUR = "EUR";
    public static void main(String[] args) throws IOException {
        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet(PropertyReader.getProperty("bnmUrl"));
        HttpResponse response = client.execute(request);

        //get response
        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

        String fullResponse = "";
        String line = "";

        while((line = rd.readLine()) != null){
            //System.out.println(line);
            fullResponse += line + "\r\n";
        }
        System.out.println(fullResponse);

        XStream xstream = new XStream();

        xstream.processAnnotations(Valute.class);
        xstream.processAnnotations(ValCurs.class);

        xstream.addImplicitCollection(ValCurs.class, "valutes", Valute.class);
        ValCurs valCurs = (ValCurs) xstream.fromXML(fullResponse);

        /*for(Valute valute : valCurs.getValutes()){
            System.out.println(valute.getName());
        }*/
        Double valueFromXML = 0.0;
        for(Valute valute : valCurs.getValutes()){
            if(valute.getCharCode().equals(EUR))
           // System.out.println(valute.getCharCode());
                valueFromXML = valute.getValue();
            break;
        }
        System.out.println(EUR + ":" + valueFromXML);


        ObjectMapper objectMapper = (new ObjectMapper()).enable(SerializationFeature.INDENT_OUTPUT);
        System.out.println(objectMapper.writeValueAsString(valCurs));

    }

}
