package sector.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import shaswat.entities.Company;
import shaswat.repository.CompanyRepository;

import java.util.List;

@Service
public class SectorService {

    @Autowired
    public CompanyRepository companyRepository;

    public MongoTemplate mongoTemplate;

    public List<Company> getList(String sector) {

        Query query = new Query();
        query.addCriteria(Criteria.where("sector").is(sector));

        return mongoTemplate.find(query,Company.class);

    }
}
