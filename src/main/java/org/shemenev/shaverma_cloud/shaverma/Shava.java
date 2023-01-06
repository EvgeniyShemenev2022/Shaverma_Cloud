package org.shemenev.shaverma_cloud.shaverma;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Shava {


    @NotNull
    @Size(min=5, message="название должно быть не меньше 5 букв")
    private String name;

    @NotNull
    @Size(min=3, message="Вы должны выбрать не менее трех ингредиентов")
    private List<Ingredient> ingredients;

    private Long id;

    private Date createdAt = new Date();


}


