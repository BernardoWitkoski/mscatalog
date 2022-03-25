package Controller;

import Dto.CategoriesDTO;
import Dto.CategoriesFormDTO;
import Dto.ProductsDTO;
import Service.CategoriesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/categories")
public class CategoriesController {

    @Autowired
    private CategoriesServiceImpl service;

    @PostMapping
    public ResponseEntity<CategoriesDTO> save(@RequestBody @Valid CategoriesFormDTO body) {
        CategoriesDTO categories = this.service.save(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(categories);
    }

    @GetMapping
    public ResponseEntity<Page<CategoriesDTO>> findAll(
            @PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable page
    ) {
        Page<CategoriesDTO> categories = this.service.findAll(page);
        return ResponseEntity.ok(categories);
    }

    @GetMapping
    public ResponseEntity<Page<ProductsDTO>> findAllProducts(
            @PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable page
    ) {
        Page<ProductsDTO> products = this.service.findAllProducts(page);
        return ResponseEntity.ok(products);
    }

    @GetMapping(path = "/:{id}")
    public ResponseEntity<CategoriesDTO> search(@PathVariable String id, @RequestBody @Valid CategoriesFormDTO body) {
        CategoriesDTO categories = this.service.search(id);
        return ResponseEntity.ok(categories);
    }

    @PutMapping(path = "/:{id}")
    public ResponseEntity<CategoriesDTO> update(@PathVariable String id, @RequestBody @Valid CategoriesFormDTO body) {
        CategoriesDTO categories = this.service.update(id, body);
        return ResponseEntity.ok(categories);
    }

    @DeleteMapping(path = "/:{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        this.service.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
