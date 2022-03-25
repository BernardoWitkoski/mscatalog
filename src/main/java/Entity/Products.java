package Entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "products")
public class Products {

    @Id
    private String id;

    private String name;

    private String description;

    private Boolean active;

    @DBRef
    private List<Variations> variations = new ArrayList<>();

}
