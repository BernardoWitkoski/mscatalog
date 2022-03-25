package Service;

import Dto.CategoriesDTO;
import Dto.CategoriesFormDTO;
import Dto.ProductsDTO;
import Entity.Categories;
import Entity.Products;
import Repository.CategoriesRepository;
import Repository.ProductsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriesServiceImpl implements CategoriesService {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private CategoriesRepository repository;

    @Autowired
    private ProductsRepository productsRepository;

    @Override
    public CategoriesDTO save(CategoriesFormDTO body) {
        Categories categories = this.repository.save(mapper.map(body, Categories.class));
        return mapper.map(categories, CategoriesDTO.class);
    }

    @Override
    public Page<CategoriesDTO> findAll(Pageable page) {
        Page<Categories> categories = this.repository.findAll(page);
        List<CategoriesDTO> listPayments = categories.getContent()
                .stream()
                .map(payment -> mapper.map(categories, CategoriesDTO.class))
                .collect(Collectors.toList());
        return new PageImpl<CategoriesDTO>(listPayments, page, categories.getTotalElements());
    }

    @Override
    public Page<ProductsDTO> findAllProducts(Pageable page) {
        Page<Products> products = this.productsRepository.findAll(page);
        List<ProductsDTO> listProducts = products.getContent()
                .stream()
                .map(product -> mapper.map(products, ProductsDTO.class))
                .collect(Collectors.toList());
        return new PageImpl<ProductsDTO>(listProducts, page, products.getTotalElements());
    }

    @Override
    public CategoriesDTO search(String id) {
        Categories categories = this.repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categorie not found"));
        return mapper.map(categories, CategoriesDTO.class);
    }

    @Override
    public CategoriesDTO update(String id, CategoriesFormDTO body) {
        Categories categories = this.repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categorie not found"));
        categories.setName(body.getName());
        categories.setActive(body.getActive());
        Categories updatedCategories = this.repository.save(categories);
        return mapper.map(updatedCategories, CategoriesDTO.class);
    }

    @Override
    public void delete(String id) {
        Categories categories = this.repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categorie not found"));
        this.repository.delete(categories);
    }


}
