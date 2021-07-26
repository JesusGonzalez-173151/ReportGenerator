/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.microservice.reportGenerator.validation;

import java.io.FileInputStream;
import java.io.InputStream;
import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;

/**
 *
 * @author Administrator
 */
public class SchemaValidator {

    public boolean validarJson(String JsonPOST) {
       boolean validado = false;
        try {
            InputStream inputstream = new FileInputStream("../ReportGenerator/src/main/resources/static/jsonSchema.json");
            JSONObject jsonSchema = new JSONObject(new JSONTokener(inputstream));
            JSONObject jsonSubject = new JSONObject(JsonPOST);

            Schema schema = SchemaLoader.load(jsonSchema);
            schema.validate(jsonSubject);

            validado = true;
        } catch (Exception e) {
               System.out.println("No validado, error en json" + e);
        }
        return validado;
    }
}
