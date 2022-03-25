package Dto;

import lombok.Data;

import java.util.List;

@Data
public class ProductsDTO {

    private String id;
    private String name;
    private String description;
    private Boolean active;
    private List<VariationsDTO> variations;

}
