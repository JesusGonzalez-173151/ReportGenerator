package com.microservice.reportGenerator;

//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.InputStream;
//import org.everit.json.schema.Schema;
//import org.everit.json.schema.ValidationException;
//import org.everit.json.schema.loader.SchemaLoader;
//import org.json.JSONException;
//import org.json.JSONObject;
//import org.json.JSONTokener;
//import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ReportGeneratorApplicationTests {

//    @Test
//    public static void givenInvalidInput_whenValidating_thenInvalid() throws ValidationException, FileNotFoundException, JSONException {
//        InputStream inputstream = new FileInputStream("C:\\Users\\Administrator\\Desktop\\ReportGenerator\\src\\main\\resources\\static\\jsonSchema.json");
//        InputStream inputstream2 = new FileInputStream("C:\\Users\\Administrator\\Desktop\\ReportGenerator\\src\\main\\resources\\static\\jsonDatas.json");
//
//        JSONObject jsonSchema = new JSONObject(
//                new JSONTokener("C:\\Users\\Administrator\\Desktop\\ReportGenerator\\src\\main\\resources\\static\\jsonSchema.json"));
//        JSONObject jsonSubject = new JSONObject(
//                new JSONTokener("C:\\Users\\Administrator\\Desktop\\ReportGenerator\\src\\main\\resources\\static\\jsonDatas.json"));
//
//        Schema schema = SchemaLoader.load(jsonSchema);
//        schema.validate(jsonSubject);
//    }

}
