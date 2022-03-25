package Service;

import Dto.ProductsDTO;
import Dto.ProductsFormDTO;
import Entity.Products;
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
public class ProductsServiceImpl implements ProductsService{

    @Autowired
    private ModelMapper mapper;

    @Autowired
    ProductsRepository repository;

    @Override
    public ProductsDTO save(ProductsFormDTO body) {
        Products products = this.repository.save(mapper.map(body, Products.class));
        return mapper.map(products, ProductsDTO.class);
    }

    @Override
    public Page<ProductsDTO> findAll(Pageable page) {
        Page<Products> products = this.repository.findAll(page);
        List<ProductsDTO> listProducts = products.getContent()
                .stream()
                .map(product -> mapper.map(products, ProductsDTO.class))
                .collect(Collectors.toList());
        return new PageImpl<ProductsDTO>(listProducts, page, products.getTotalElements());
    }

    @Override
    public ProductsDTO search(String id) {
        Products products = this.repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        return mapper.map(products, ProductsDTO.class);
    }

    @Override
    public ProductsDTO update(String id, ProductsFormDTO body) {
        Products products = this.repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        products.setName(body.getName());
        products.setDescription(body.getDescription());
        products.setActive(body.getActive());
        Products updatedProducts = this.repository.save(products);
        return mapper.map(updatedProducts, ProductsDTO.class);
    }

    @Override
    public void delete(String id) {
        Products products = this.repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        this.repository.delete(products);
    }
}
