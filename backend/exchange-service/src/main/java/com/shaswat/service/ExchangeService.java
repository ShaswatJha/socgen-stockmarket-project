package com.shaswat.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import com.shaswat.entities.Exchange;
import com.shaswat.repository.ExchangeRepository;
import shaswat.entities.Company;
import shaswat.repository.CompanyRepository;

import java.util.List;

@Service
public class ExchangeService {

    @Autowired
    private ExchangeRepository exchangeRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Exchange> getExchanges()
    {
        return exchangeRepository.findAll();
    }


    public String SaveExchange(Exchange exchange){
        exchangeRepository.save(exchange);
        return "Added Exchange with id : "+exchange.getId();
    }

    public List<Company> getCompany(int id){

        Query query = new Query();
        query.addCriteria(Criteria.where("exchange_id").is(id));
        return mongoTemplate.find(query,Company.class);
    }

}
