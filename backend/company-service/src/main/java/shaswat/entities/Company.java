package shaswat.entities;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;


@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(collection ="Company" )
public class Company {

    @Column(length = 8)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;

    @Column(length = 30)
    public String name;

    @Column(length = 15)
    public float turnover;

    @Column(length = 20)
    public String ceo;

    @Column
    public List<String> board_of_directors;

    @Column
    public List<Integer> stock_exchanges;

    @Column(length = 20)
    public String sector;

    @Column(length = 200)
    public String brief;

    @Column(length = 10)
    public String stock_code;

}
