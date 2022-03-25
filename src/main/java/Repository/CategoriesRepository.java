package Repository;

import Entity.Categories;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoriesRepository extends MongoRepository<Categories, String> {


}
