package shaswat.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import shaswat.entities.IPO;

@Repository
public interface IPORepository extends MongoRepository<IPO,Integer> {
}
