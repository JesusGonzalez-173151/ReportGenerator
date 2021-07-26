package com.microservice.reportGenerator;

import com.microservice.reportGenerator.validation.AuthValidator;
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
import org.json.JSONArray;
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
            consumes = {MediaType.APPLICATION_JSON_VALUE})//o usar consume = application/json.......sin llaves
    public ResponseEntity<String> reporteGenerado(@RequestBody String json) throws Exception {
        AuthValidator sv = new AuthValidator();
        String str = " ";

        try {
            JSONObject jsone = new JSONObject(json);//json recibido por el post de parte de la plataforma cliente
            //extrae el objeto data dentro que viene del objeto json
            //despues extrae el arreglo del orders del data
            //despues extrae el primer objeto(primer orden) del arreglo de orders
            //finalmente obtiene el atributo del objeto extraido de la lista de orders
            System.out.println(jsone.getJSONObject("data").getJSONArray("orders").getJSONObject(0).getString("cliente"));
            //lo mismo pero seccionado para mayor entendimiento
            JSONObject data = jsone.getJSONObject("data");
            JSONArray orders = data.getJSONArray("orders");
            JSONObject order = orders.getJSONObject(0);
            String nombre = order.getString("cliente");
            //System.out.println("Resultado extraido: "+ nombre);

            if (sv.autenticacion(jsone)) {
                str = "Paso 1 autenticar";
                System.out.println("Autenticación aprobada");
                if (sv.validarJson(jsone)) {
                    str = "Paso 2 validar";
                    System.out.println("Validación de esquema aprobada");
                }else{
                    str = "Paso 2 invalido";
                    System.out.println("Validación de esquema invalida");
                }
            } else {
                str = "Paso 1 denegado";
                System.out.println("Autenticación fallida");
            }
        } catch (Exception e) {
            System.out.println("No validado, error en json" + e);
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
