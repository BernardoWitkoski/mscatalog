package Dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class VariationsDTO {

    private String id;
    private String color;
    private String size;
    private BigDecimal price;
    private int quantity;

}
