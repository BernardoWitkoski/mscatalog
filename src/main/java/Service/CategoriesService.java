package Service;

import Dto.CategoriesDTO;
import Dto.CategoriesFormDTO;
import Dto.ProductsDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public interface CategoriesService {

    CategoriesDTO save(CategoriesFormDTO body);

    CategoriesDTO search(String id);

    CategoriesDTO update(String id, CategoriesFormDTO body);

    void delete(String id);

    Page<CategoriesDTO> findAll(Pageable page);

    Page<ProductsDTO> findAllProducts(Pageable page);

}
