package Entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "categories")
public class Categories {

    @Id
    private String id;

    private String name;

    private Boolean active;

    @DBRef
    private List<Products> products = new ArrayList<>();

}
