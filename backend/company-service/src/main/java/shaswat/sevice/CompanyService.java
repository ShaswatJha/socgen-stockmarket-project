package shaswat.sevice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.data.mongodb.core.MongoTemplate;
import shaswat.entities.Company;
import shaswat.entities.IPO;
import shaswat.entities.StockPrice;
import shaswat.repository.CompanyRepository;
import shaswat.repository.IPORepository;
import shaswat.repository.StockPriceRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private IPORepository ipoRepository;

    @Autowired
    private StockPriceRepository stockPriceRepository;

    @Autowired
    public MongoTemplate mongoTemplate;

    public Optional<Company> getCompanyDetails(@PathVariable int id){
        return companyRepository.findById(id);
    }

    public String saveCompany(@RequestBody Company company)
    {
        companyRepository.save(company);
        return "Action Completed";
    }

    public Optional<IPO> getCompanyIPODetails(@PathVariable int id){
        return ipoRepository.findById(id);
    }

    public List<StockPrice> getCompanyStockPrice(int exchangeId, String companyId, LocalDate from_period,
                                                 LocalTime to_period, int periodicity )
    {
        Query query = new Query();
        query.addCriteria(Criteria.where("stock_exchange").is(exchangeId).and("stock_code")
                        .is(companyId).and("date").gt(from_period.plusDays(periodicity)).and("date").lt((to_period)));

        return mongoTemplate.find(query,StockPrice.class);

    }

}
