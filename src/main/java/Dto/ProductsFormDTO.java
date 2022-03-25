package Dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class ProductsFormDTO {

    @NotNull
    private String name;

    @NotNull
    private String description;

    @NotNull
    private Boolean active;

    @NotNull
    private List<VariationsDTO> variations;

}
