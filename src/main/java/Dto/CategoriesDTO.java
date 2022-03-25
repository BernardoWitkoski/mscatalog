package Dto;


import lombok.Data;

import java.util.List;

@Data
public class CategoriesDTO {

    private String id;
    private String name;
    private Boolean active;
    private List<ProductsDTO> products;

}
