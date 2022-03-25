package Controller;

import Dto.VariationsDTO;
import Dto.VariationsFormDTO;
import Service.VariationsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/variations")
public class VariationsController {

    @Autowired
    private VariationsServiceImpl service;

    @PostMapping
    public ResponseEntity<VariationsDTO> save(@RequestBody @Valid VariationsFormDTO body) {
        VariationsDTO variations = this.service.save(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(variations);
    }

    @PutMapping(path = "/:{id}")
    public ResponseEntity<VariationsDTO> update(@PathVariable String id, @RequestBody @Valid VariationsFormDTO body) {
        VariationsDTO variations = this.service.update(id, body);
        return ResponseEntity.ok(variations);
    }

    @DeleteMapping(path = "/:{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        this.service.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }




}
