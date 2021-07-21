package com.microservice.reportGenerator;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.FileWriter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
//import org.json.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.JsonbHttpMessageConverter;
import org.json.simple.JSONArray; //una libreria de json debe traer un metodo que convierte string a json asi nomas
import org.json.simple.JSONObject;//buscate uno xd , ya una vez hecho eso ya podemos hacer lo del esquema

/**
 *
 * @author USER
 */
@RestController
@RequestMapping("/") //la pagina template index la detecta automaticamente
public class Controlador {

    private static FileWriter file;

    /**
     * Este metodo post consume el json con los datos a generar en un reporte, lo
     * recibe en forma de object, y los datos toString() los mete a una variable string y
     * lo devuelve al navegador.
     * Intento despues meter ese string en documento txt el cual hare .json y dejarlo como archivo local
     * para trabajar con el....ahi me quede
     * @param json
     * @return
     * @throws Exception
     */
    @RequestMapping(
            method = RequestMethod.POST,
            path = "/reporteGenerado",
            consumes = "application/json")
    public ResponseEntity<String> reporteGenerado(@RequestBody Object json) throws Exception {

        String ob = json.toString();

        JSONObject copy = new JSONObject(ob);

        try {
            JSONObject copy = new JSONObject(ob);
            file = new FileWriter("/Users/Shared/crunchify.txt");
            file.write(copy.toJSONString());
            System.out.println("Successfully Copied JSON Object to File...");
            System.out.println("\nJSON Object: " + copy);
            System.out.println(ob);
            return new ResponseEntity<String>(ob + " ", HttpStatus.OK);

            // jo = new JSONObject(json.toString());
            //jo = copy;
            // return new ResponseEntity<String>(, HttpStatus.OK);
        } catch (Exception e) {

        }
        return new ResponseEntity<String>("no jala", HttpStatus.OK);
    }

//    @GetMapping("/generate_pdf")//devuelve solo texto 
//    public String pdfReport() {
//        return "Toma tu pdf jaja";
//    }
//
//    @PostMapping("/generate_xls")//devuelve solo texto 
//    public String xlsReport() {
//        return "<div>Toma tu excel jaja</div>";
//    }
//     @RequestMapping("/") public ModelAndView index () { ModelAndView
//     modelAndView = new ModelAndView(); modelAndView.setViewName("index");
//      return modelAndView; }
}
