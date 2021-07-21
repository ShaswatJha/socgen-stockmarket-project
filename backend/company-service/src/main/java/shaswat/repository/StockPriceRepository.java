package shaswat.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import shaswat.entities.StockPrice;

@Repository
public interface StockPriceRepository extends MongoRepository<StockPrice,Integer> {
}
