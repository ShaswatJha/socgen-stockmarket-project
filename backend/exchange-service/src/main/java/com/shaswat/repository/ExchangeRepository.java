package com.shaswat.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.shaswat.entities.Exchange;


@Repository
public interface ExchangeRepository extends MongoRepository<Exchange,Integer> {

}
