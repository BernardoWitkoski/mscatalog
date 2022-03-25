package Service;

import Dto.VariationsDTO;
import Dto.VariationsFormDTO;
import org.springframework.stereotype.Component;

@Component
public interface VariationsService {

    VariationsDTO save(VariationsFormDTO body);

    VariationsDTO update(String id, VariationsFormDTO body);

    void delete(String variation_id);

}
