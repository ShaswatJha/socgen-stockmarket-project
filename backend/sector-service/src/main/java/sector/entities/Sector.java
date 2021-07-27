package sector.entities;


import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Column;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Sector")
public class Sector {

    @Column(length = 20)
    @Id
    public String sector;

    @Column(length = 15)
    public double market_capital;

    @Column
    public LocalDate localDate;

}
