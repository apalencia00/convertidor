package conversor.dev.com.convertidor.Service;

import conversor.dev.com.convertidor.Entity.Convert;
import conversor.dev.com.convertidor.Repository.ConvertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;


@Service
@Transactional
public class ConvertServiceImpl implements ConvertService {

    @Autowired
    ConvertRepository convertRepository;

    @Override
    public Convert saveConvert(Convert c) {

        convertRepository.save(c);

        return c;
    }

    @Override
    public ArrayList<Convert> listConvert() {

        return (ArrayList<Convert>) convertRepository.findAll();


    }

    @Override
    public Convert getDolar(String s, String t, int p) {

        Convert convert = convertRepository.findConvertByVlAndTs(s,t);


        return convert;
    }
}
