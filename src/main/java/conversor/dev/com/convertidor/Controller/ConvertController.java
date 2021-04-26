package conversor.dev.com.convertidor.Controller;



import com.fasterxml.jackson.databind.ObjectMapper;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import conversor.dev.com.convertidor.Entity.Convert;
import conversor.dev.com.convertidor.Entity.Rates;
import conversor.dev.com.convertidor.Entity.USD;
import conversor.dev.com.convertidor.Service.ConvertService;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import sun.net.www.http.HttpClient;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;

@RestController
@RequestMapping("/api")
public class ConvertController {

    @Autowired
    ConvertService convertService;

    @GetMapping(value = "/index")
    public @ResponseBody
    String index(){
        return "hola mundo";
    }

    @GetMapping(value = "/convert/{vl}/{ts}")
    public @ResponseBody
    Convert convertMoney(@PathVariable  String vl, @PathVariable  String ts ) {

        String output = "";
        boolean keepGoing = true;

        Convert conv = null;
        if (convertService.getDolar(vl, ts, 1) != null) {
            conv = convertService.getDolar(vl, ts, 1);
        } else {
            // send request API and save data

            ObjectMapper mapper = new ObjectMapper();

            try {
                HttpResponse<String> response = Unirest.get("https://currency-converter5.p.rapidapi.com/currency/convert?format=json&from=AUD&to=USD&amount=10")
                        .header("x-rapidapi-key", "3a3b7e19eemsh752fd78928cd762p1c1f45jsnce96ac4333fb")
                        .header("x-rapidapi-host", "currency-converter5.p.rapidapi.com")
                        .asString();

                JSONParser parser = new JSONParser();
                JSONObject json = (JSONObject) parser.parse(response.getBody().toString());

                // Object Rates
                System.out.println(json.get("rates"));

                JSONObject json_rates = (JSONObject) json.get("rates");

                //Object USD
                System.out.println(json_rates.get("USD"));

                // ACCESS USD OBJECT

                JSONObject json_usd = (JSONObject) json_rates.get("USD");

                // Ramdom ID

                int _id = (int) Math.round( Math.random() * 10000000 - 1 );

                conv = new Convert(
                        _id,
                        json.get("base_currency_code").toString(),
                        json.get("base_currency_name").toString(),
                        json.get("amount").toString(),
                        json.get("updated_date").toString(),

                                new Rates(


                                                new USD(
                                                        json_usd.get("currency_name").toString(),
                                                        json_usd.get("rate").toString(),
                                                        json_usd.get("rate_for_amount").toString()
                                                )
                                                ,
                                                true


                                )



                );

                System.out.println(conv);


                convertService.saveConvert(conv);




            } catch (UnirestException | ParseException e) {
                e.printStackTrace();
            }


        }

        return conv;

    }

    

}
