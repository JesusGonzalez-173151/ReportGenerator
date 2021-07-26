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
public class AuthValidator {

    public boolean autenticacion(JSONObject jsonPOST) {
        boolean validado = false;
        try {
            //lo mismo pero seccionado para mayor entendimiento
            if (jsonPOST.getString("user").equalsIgnoreCase("trazen")) {
                System.out.println("es trazen pasa");
                validado = true;
            }
        } catch (Exception e) {
            System.out.println("No autenticado, error en json" + e);
        }
        return validado;
    }

    public boolean validarJson(JSONObject jsonPOST) {
        boolean validado = false;
        try {
            InputStream inputstream = new FileInputStream("../ReportGenerator/src/main/resources/static/jsonSchema.json");
            JSONObject jsonSchema = new JSONObject(new JSONTokener(inputstream));

            Schema schema = SchemaLoader.load(jsonSchema);
            schema.validate(jsonPOST);

            validado = true;
        } catch (Exception e) {
            System.out.println("No validado, error en json" + e);
        }
        return validado;
    }
}
