package conversor.dev.com.convertidor.Service;

import conversor.dev.com.convertidor.Entity.Indicator;

public interface IndicatorService {

    Indicator saveIndicator(Indicator i);
    Indicator getIndicator(String fecha);

}
