package com.dietbuilder.domain.model.recipe;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class IngredientPK implements Serializable {

    @Column(name = "comestible_product_id")
    private Long comestibleProductId;

    @Column(name = "recipe_id")
    private Long recipeId;
}
