package Entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Data
@Document(collection = "variations")
public class Variations {

    @Id
    private String id;

    private String color;

    private String size;

    private BigDecimal price;

    private int quantity;

}
