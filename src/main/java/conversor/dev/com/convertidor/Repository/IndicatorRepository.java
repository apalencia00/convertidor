package conversor.dev.com.convertidor.Repository;

import conversor.dev.com.convertidor.Entity.Convert;
import conversor.dev.com.convertidor.Entity.Indicator;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface IndicatorRepository extends MongoRepository<Indicator,Integer> {

    @Query("{serie:{$elemMatch:{fecha : $0}}}")
    Indicator findIndicatorBySerieFecha(String fecha);

}
