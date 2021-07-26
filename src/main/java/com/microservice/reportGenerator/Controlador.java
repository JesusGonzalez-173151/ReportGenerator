package com.microservice.reportGenerator;

import java.io.FileInputStream;
import java.io.InputStream;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;

/**
 *
 * @author USER
 */
@RestController
@RequestMapping("/") //la pagina template index la detecta automaticamente
public class Controlador {

    /**
     * Este metodo post consume el json con los datos a generar en un reporte,
     * lo recibe en forma de object, y los datos toString() los mete a una
     * variable string y lo devuelve al navegador. Intento despues meter ese
     * string en documento txt el cual hare .json y dejarlo como archivo local
     * para trabajar con el....ahi me quede
     *
     * @param json
     * @return
     * @throws Exception
     */
    @RequestMapping(
            method = RequestMethod.POST,
            path = "/reporteGenerado",
            consumes = "application/json")
    public ResponseEntity<String> reporteGenerado(@RequestBody String json) throws Exception {
        try {
            InputStream inputstream = new FileInputStream("../ReportGenerator/src/main/resources/static/jsonSchema.json");
            JSONObject jsonSchema = new JSONObject(new JSONTokener(inputstream));
            JSONObject jsonSubject = new JSONObject(json);

            Schema schema = SchemaLoader.load(jsonSchema);
            schema.validate(jsonSubject);

            return new ResponseEntity<>(json + " jala", HttpStatus.OK);
        } catch (Exception e) {

        }
        return new ResponseEntity<>("no jala", HttpStatus.OK);
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
