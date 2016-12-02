package com.hzx.opac;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

/**
 * Created by hz on 16-12-1.
 */
public class TestJson{
    ObjectMapper objectMapper = null;
    JsonGenerator jsonGenerator = null;

    @Before
    public void init(){
        objectMapper = new ObjectMapper();
        JsonFactory factory = new JsonFactory();
        try {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
            jsonGenerator = factory.createGenerator(writer);
            jsonGenerator.writeStartObject();
            jsonGenerator.writeStringField("error_code", "200");
            jsonGenerator.writeEndObject();
//            System.out.println(jsonGenerator.toString());
            JsonStreamContext context = jsonGenerator.getOutputContext();
            jsonGenerator.close();
            InputStreamReader reader = new InputStreamReader(System.in);
            System.out.println(reader.read());


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @Test
    public void testJson(){
        try {
            jsonGenerator.writeStartObject();
            jsonGenerator.writeStringField("error_code", "200");
            jsonGenerator.writeEndObject();
            System.out.println(jsonGenerator.toString());
            jsonGenerator.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
