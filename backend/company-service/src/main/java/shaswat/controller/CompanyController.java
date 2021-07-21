package shaswat.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shaswat.dto.ResponseObject;
import shaswat.entities.Company;
import org.springframework.beans.factory.annotation.Autowired;
import shaswat.entities.IPO;
import shaswat.entities.StockPrice;
import shaswat.repository.CompanyRepository;
import shaswat.repository.IPORepository;
import shaswat.sevice.CompanyService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api")
public class CompanyController {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private IPORepository ipoRepository;

    @Autowired
    private CompanyService companyService;

    @GetMapping(value = "/company/{id}")
    public Optional<Company> getCompanyDetails(@PathVariable int id){
        return companyService.getCompanyDetails(id);
    }

    @PostMapping(value = "/company")
    public ResponseEntity<ResponseObject> saveCompany(@RequestBody Company company)
    {
        ResponseObject responseObject = new ResponseObject();
        try {
            companyService.saveCompany(company);
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

    @GetMapping(value = "/companyIPO/{id}")
    public Optional<IPO> getCompanyIPODetails(@PathVariable int id){
        return companyService.getCompanyIPODetails(id);
    }

    @GetMapping(value = "{exchangeId}/{companyId}/{from_period}/{to_period}/{periodicity}")
    public List<StockPrice> getCompanyStockPrice(@PathVariable int exchangeId, @PathVariable String companyId,
                                                 @PathVariable LocalDate from_period, @PathVariable LocalTime to_period,
                                                 @PathVariable int periodicity){

        return companyService.getCompanyStockPrice(exchangeId,companyId,from_period,to_period,periodicity);

    }


    // This service to be made during frontend creation

}
