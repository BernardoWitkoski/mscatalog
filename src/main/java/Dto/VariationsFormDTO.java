package Dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class VariationsFormDTO {

    @NotNull
    private String color;

    @NotNull
    private String size;

    @NotNull
    private BigDecimal price;

    @NotNull
    private int quantity;

}
