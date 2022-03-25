package Repository;

import Entity.Variations;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VariationsRepository extends MongoRepository<Variations, String> {


}
