package sector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import sector.repository.SectorRepository;


@SpringBootApplication(scanBasePackages={
        "com.shaswat", "shaswat","sector"})
@EnableMongoRepositories(basePackageClasses = SectorRepository.class)
public class SectorApplication {

    public static void main(String[] args) {
        SpringApplication.run(SectorApplication.class, args);
    }
}