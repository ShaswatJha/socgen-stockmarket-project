package sector.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sector.service.SectorService;
import shaswat.entities.Company;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class SectorController {

    @Autowired
    public SectorService sectorService;

    @GetMapping(value = "/sector/{sector}")
    public List<Company> getList(@PathVariable String sector){
        return sectorService.getList(sector);
    }
}
