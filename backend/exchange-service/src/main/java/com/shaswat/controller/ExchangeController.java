package com.shaswat.controller;


import com.shaswat.dto.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.shaswat.entities.Exchange;
import com.shaswat.service.ExchangeService;
import shaswat.entities.Company;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class ExchangeController {

    private final ExchangeService exchangeService;

    @Autowired
    public ExchangeController(ExchangeService exchangeService) {
        this.exchangeService = exchangeService;
    }


    @GetMapping(value = "/exchange")
    public List<Exchange> getExchanges()
    {
        return exchangeService.getExchanges();
    }

    @PostMapping(value="/exchange")
    public ResponseEntity<ResponseObject> SaveExchange(@RequestBody Exchange exchange){

        ResponseObject responseObject = new ResponseObject();
        try {
            exchangeService.SaveExchange(exchange);
            responseObject.setStatus(true);
            responseObject.setMessage("Action Successful");
            return ResponseEntity.ok(responseObject);
        }
        catch (Exception e)
        {
            responseObject.setStatus(false);
            responseObject.setError("Invalid Input");
            return new ResponseEntity(responseObject, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "getCompanies/{id}")
    public List<Company> getCompany(@PathVariable int id){
        return exchangeService.getCompany(id);
    }

}
