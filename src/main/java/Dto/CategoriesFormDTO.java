package Dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CategoriesFormDTO {

    @NotNull
    private String name;

    @NotNull
    private Boolean active;

}
