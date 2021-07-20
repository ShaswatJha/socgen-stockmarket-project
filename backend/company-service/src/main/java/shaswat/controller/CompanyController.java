package shaswat.controller;

import org.springframework.web.bind.annotation.*;
import shaswat.entities.Company;
import org.springframework.beans.factory.annotation.Autowired;
import shaswat.repository.CompanyRepository;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class CompanyController {

    @Autowired
    private CompanyRepository companyRepository;

    @GetMapping(value = "/company")
    public List<Company> getCompanies(){
        return companyRepository.findAll();
    }

    @PostMapping(value = "/company")
    public String saveCompany(@RequestBody Company company)
    {
        companyRepository.save(company);
        return "Action Completed";
    }
}
