package shaswat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shaswat.entities.IPO;
import shaswat.sevice.IPOService;

@RestController
@RequestMapping(path = "/api")
public class IPOController {

    @Autowired
    public IPOService ipoService;

    @PostMapping(value = "/IPO")
    public String saveIPO(@RequestBody IPO ipo){
        return ipoService.saveIPO(ipo);
    }
}
