package Service;

import Dto.ProductsDTO;
import Dto.ProductsFormDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;


@Component
public interface ProductsService {

    ProductsDTO save(ProductsFormDTO body);

    Page<ProductsDTO> findAll(Pageable page);

    ProductsDTO search(String id);

    ProductsDTO update(String id, ProductsFormDTO body);

    void delete(String id);

}
