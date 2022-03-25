package Controller;

import Dto.ProductsDTO;
import Dto.ProductsFormDTO;
import Service.ProductsServiceImpl;
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
@RequestMapping("/v1/products")
public class ProductsController {

    @Autowired
    private ProductsServiceImpl service;

    @PostMapping
    public ResponseEntity<ProductsDTO> save(@RequestBody @Valid ProductsFormDTO body) {
        ProductsDTO products = this.service.save(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(products);
    }

    @GetMapping
    public ResponseEntity<Page<ProductsDTO>> findAll(
            @PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable page
    ) {
        Page<ProductsDTO> products = this.service.findAll(page);
        return ResponseEntity.ok(products);
    }

    @GetMapping(path = "/:{id}")
    public ResponseEntity<ProductsDTO> search(@PathVariable String id, @RequestBody @Valid ProductsFormDTO body) {
        ProductsDTO products = this.service.search(id);
        return ResponseEntity.ok(products);
    }

    @PutMapping(path = "/:{id}")
    public ResponseEntity<ProductsDTO> update(@PathVariable String id, @RequestBody @Valid ProductsFormDTO body) {
        ProductsDTO products = this.service.update(id, body);
        return ResponseEntity.ok(products);
    }

    @DeleteMapping(path = "/:{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        this.service.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
