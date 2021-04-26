package conversor.dev.com.convertidor.Service;

import conversor.dev.com.convertidor.Entity.Indicator;
import conversor.dev.com.convertidor.Repository.IndicatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
@Transactional
public class IndicatorServiceImpl implements IndicatorService {

    @Autowired
    IndicatorRepository indicatorRepository;

    @Override
    public Indicator saveIndicator(Indicator i) {
       return indicatorRepository.save(i);
    }

    @Override
    public Indicator getIndicator(String fecha) {

        Query query = new Query();
        query.addCriteria(Criteria.where("series").andOperator(Criteria.where("fecha").is(fecha)));
        Indicator indi = indicatorRepository.findIndicatorBySerieFecha(fecha);

        return indi;
    }
}
