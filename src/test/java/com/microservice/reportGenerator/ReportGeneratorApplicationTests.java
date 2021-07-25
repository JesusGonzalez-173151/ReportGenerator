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

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ReportGeneratorApplicationTests {

//    @org.junit.Test
//    void givenInvalidInput_whenValidating_thenInvalid() throws ValidationException, FileNotFoundException {
//        InputStream inputstream = new FileInputStream("C:\\Users\\USER\\Documents\\NetBeansProjects\\ReportGenerator\\src\\main\\resources\\static\\jsonSchema.json");
//        InputStream inputstream2 = new FileInputStream("C:\\Users\\USER\\Documents\\NetBeansProjects\\ReportGenerator\\src\\main\\resources\\static\\jsonDatas.json");
//
//        JSONObject jsonSchema = new JSONObject(
//                new JSONTokener(inputstream));
//        JSONObject jsonSubject = new JSONObject(
//                new JSONTokener(inputstream2));
//
//        Schema schema = SchemaLoader.load(jsonSchema);
//        schema.validate(jsonSubject);
//    }

}
