package conversor.dev.com.convertidor.Service;

import conversor.dev.com.convertidor.Entity.Convert;

import java.util.ArrayList;


public interface ConvertService {

    Convert saveConvert(Convert c);
    ArrayList<Convert> listConvert();
    Convert getDolar(String s, String t, int p);

}
