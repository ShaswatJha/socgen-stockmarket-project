package shaswat.sevice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shaswat.entities.IPO;
import shaswat.repository.IPORepository;

@Service
public class IPOService {

    @Autowired
    public IPORepository ipoRepository;

    public String saveIPO(IPO ipo) {
        ipoRepository.save(ipo);
        return "Action Completed";
    }
}
