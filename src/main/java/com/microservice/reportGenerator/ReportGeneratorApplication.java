package com.microservice.reportGenerator;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import javax.validation.ValidationException;
import org.everit.json.schema.Schema;
import org.everit.json.schema.*;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReportGeneratorApplication {

    public static void main(String[] args) {
        //SpringApplication.run(ReportGeneratorApplication.class, args);
        try {
            givenInvalidInput_whenValidating_thenInvalid();
            System.out.println("pasó");
        } catch (Exception e) {
            System.out.println("no pasó");
        }
        
    }
//    private static InputStream inputStreamFromClasspath(String path) {
//        return Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
//    }
    @Test
    public static void givenInvalidInput_whenValidating_thenInvalid() throws ValidationException, FileNotFoundException {
        InputStream inputstream = new FileInputStream("C:\\Users\\Administrator\\Desktop\\ReportGenerator\\src\\main\\resources\\static\\jsonSchema.json");
        InputStream inputstream2 = new FileInputStream("C:\\Users\\Administrator\\Desktop\\ReportGenerator\\src\\main\\resources\\static\\jsonDatas.json");

        JSONObject jsonSchema = new JSONObject(
                new JSONTokener(inputstream));
        JSONObject jsonSubject = new JSONObject(
                new JSONTokener(inputstream2));

        Schema schema = SchemaLoader.load(jsonSchema);
        schema.validate(jsonSubject);
    }

}
