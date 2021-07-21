package shaswat.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import shaswat.entities.Company;

@Repository
public interface CompanyRepository extends MongoRepository<Company,Integer> {


}
