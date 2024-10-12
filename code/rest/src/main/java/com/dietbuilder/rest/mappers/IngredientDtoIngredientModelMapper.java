package com.dietbuilder.rest.mappers;

import com.dietbuilder.domain.daos.ComestibleProductDao;
import com.dietbuilder.domain.model.recipe.Ingredient;
import com.dietbuilder.domain.model.recipe.IngredientUnit;
import com.dietbuilder.model.IngredientDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class IngredientDtoIngredientModelMapper {

    @Autowired
    private ComestibleProductDao comestibleProductDao;

    @Autowired
    private ComestibleProductDtoComestibleProductModelMapper comestibleProductMapper;

    public Ingredient sourceToDestination(IngredientDto source) {
        return Ingredient.builder()
                .comestibleProduct(comestibleProductMapper.sourceToDestination(source.getComestibleProduct()))
                .amount(source.getAmount())
                .ingredientUnit(IngredientUnit.valueOf(source.getIngredientUnit().getValue()))
                .build();
    }

    public List<Ingredient> sourceToDestination(List<IngredientDto> source) {
        return source.stream().map(this::sourceToDestination).toList();
    }

    public IngredientDto destinationToSource(Ingredient destination) {
        IngredientDto ingredientDto = new IngredientDto();
        ingredientDto
                .comestibleProduct(comestibleProductMapper.destinationToSource(comestibleProductDao.get(destination.getComestibleProduct().getId())))
                .amount(destination.getAmount())
                .ingredientUnit(IngredientDto.IngredientUnitEnum.valueOf(destination.getIngredientUnit().toString()));
        return ingredientDto;
    }

    public List<IngredientDto> destinationToSource(List<Ingredient> destination) {
        return destination.stream().map(this::destinationToSource).toList();
    }
}
