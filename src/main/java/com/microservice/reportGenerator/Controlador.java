package com.microservice.reportGenerator;

import com.microservice.reportGenerator.validation.SchemaValidator;
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
     * lo recibe en forma de String con el formato escrito de JSON, Despues se
     * crea un JSONObject con ese String para despues compararse con otro
     * JSONObject que contiene el schema de validacion para el json recibido
     *
     * @param json
     * @return
     * @throws Exception
     */
    @RequestMapping(
            method = RequestMethod.POST,
            path = "/reporteGenerado",
            consumes = {MediaType.APPLICATION_JSON_VALUE})//consume = application/json.......sin llaves
    public ResponseEntity<String> reporteGenerado(@RequestBody String json) throws Exception {
        SchemaValidator sv = new SchemaValidator();
        String str = " ";
        if (sv.validarJson(json)) {
            str = "pasado";
        } else {
            str = "no pasado";
        }
        return new ResponseEntity<>(str, HttpStatus.OK);
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
