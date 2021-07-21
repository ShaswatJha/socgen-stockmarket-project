package shaswat.entities;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Document(collection = "IPO")
public class IPO {

    @Id
    public int id;

    public String name;

    public int stock_exchange;

    public int price_per_share;

    public int number_of_shares;

    public Date open_date_time;

    public String remarks;

}
