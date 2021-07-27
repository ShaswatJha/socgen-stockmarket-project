package sector.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import sector.entities.Sector;

@Repository
public interface SectorRepository extends MongoRepository<Sector,String> {

}
