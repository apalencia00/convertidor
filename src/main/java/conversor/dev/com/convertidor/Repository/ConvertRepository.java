package conversor.dev.com.convertidor.Repository;

import conversor.dev.com.convertidor.Entity.Convert;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


public interface ConvertRepository extends MongoRepository<Convert,Integer> {

    @Query("{base_currency_name:'?0'},{currency_name:?1}")
    Convert findConvertByVlAndTs(String vl,String ts);

}
