package conversor.dev.com.convertidor.Controller;


import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import conversor.dev.com.convertidor.Entity.Indicator;
import conversor.dev.com.convertidor.Entity.Serie;
import conversor.dev.com.convertidor.Service.IndicatorService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

@RestController
@RequestMapping("/api/indicator")
public class IndicatorController {

    @Autowired
    IndicatorService indicatorService;

    @GetMapping(value = "/index")
    public @ResponseBody
    String index(){
        return "hola mundo";
    }


    @GetMapping(value = "/get/{fecha}")
    public @ResponseBody
    Indicator getIndicatorData(@PathVariable String indicatorstr ,@PathVariable String fecha ) throws UnirestException, ParseException, java.text.ParseException {

        Indicator indit = indicatorService.getIndicator(fecha);

        if ( indit == null ){

            HttpResponse<String> response = Unirest.get("https://mindicador.cl/api/"+indicatorstr+"/"+fecha).asString();

            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(response.getBody().toString());

            // get properties Series
            JSONArray json_serie = (JSONArray) json.get("serie");
            System.out.println(json_serie.get(0));

            JSONObject json_array_serie = (JSONObject) json_serie.get(0);

            int _id = (int) Math.round( Math.random() * 10000000 - 1 );
            Date date1=new SimpleDateFormat("dd-MM-yyyy").parse(json_array_serie.get("fecha").toString());

            indit = new Indicator(

                    _id,
                     json.get("version").toString(),
                     json.get("autor").toString(),
                     json.get("codigo").toString(),
                     json.get("nombre").toString(),
                     json.get("unidad_medida").toString(),
                     Arrays.asList(

                            new Serie(
                                    date1.toString(),
                                    Double.parseDouble(json_array_serie.get("valor").toString())
                            )

                    )

            );

            indicatorService.saveIndicator(indit);

        }else{

            System.out.println("ingreso aca");
            indit = indicatorService.getIndicator(fecha);

        }

        return indit;


    }


}
