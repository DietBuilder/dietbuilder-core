package com.dietbuilder.core.services;

import com.dietbuilder.boot.config.InitializationProperties;
import com.dietbuilder.domain.daos.ComestibleProductDao;
import com.dietbuilder.domain.daos.RecipeDao;
import com.dietbuilder.domain.model.recipe.Ingredient;
import com.dietbuilder.domain.model.recipe.IngredientUnit;
import com.dietbuilder.domain.model.recipe.Meal;
import com.dietbuilder.domain.model.recipe.Recipe;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class LoadRecipesForXlsx {

    @Autowired
    private InitializationProperties initializationProperties;

    private String rootDir;

    @Autowired
    private RecipeDao recipeDao;

    @Autowired
    private ComestibleProductDao comestibleProductDao;

    @PostConstruct
    private void setRootDir() {
        this.rootDir = System.getProperty("user.dir");
    }

    public List<Recipe> loadFromXlsxFile() {
        ArrayList<Recipe> recipes = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(rootDir + initializationProperties.getFilePath())) {
            XSSFSheet sheet = new XSSFWorkbook(fis)
                    .getSheetAt(1);

            // removing header
            XSSFRow rowToRemove = sheet.getRow(0);
            sheet.removeRow(rowToRemove);

            // iterating through all xlsx rows
            Iterator<Row> rowIterator = sheet.rowIterator();
            log.info("Loading meals from xlsx file" + initializationProperties.getFilePath());

            XSSFRow recipeRow = null;
            List<XSSFRow> ingredientRows = null;
            XSSFRow row;
            while (rowIterator.hasNext()) {

                row = (XSSFRow) rowIterator.next();

                //check if this is row with basic meal infos, or with concrete ingredient data
                if ((Optional.ofNullable(row.getCell(0)).isPresent())) {
                    // check if this is first iteration, if now, all
                    if (recipeRow != null) {
                        createRecipe(recipes, recipeRow, ingredientRows);
                    }

                    recipeRow = row;
                    ingredientRows = new ArrayList<>();
                } else {
                    assert ingredientRows != null : "Ingredients row list have to be initialized";
                    ingredientRows.add(row);
                }
            }
            assert ingredientRows != null : "Ingredients row list have to be initialized";
            createRecipe(recipes, recipeRow, ingredientRows);
        } catch (IOException e) {
            log.error("Loading meals from xlsx file has failed", e);
        }

        return recipes;
    }

    private void createRecipe(List<Recipe> recipes, XSSFRow recipeRow, List<XSSFRow> ingredientsRow) {
        List<Ingredient> ingredients = ingredientsRow.stream().map(this::loadRecipeIngredientFromXlsxRow).toList();
        Recipe recipe = loadRecipeHeaderFromXlsxRow(recipeRow, ingredients);
        recipes.add(recipe);
    }

    /**
     * @return Meal
     * Method pull mealName, description and recipe from row and save it a Meal entity.
     */
    private Recipe loadRecipeHeaderFromXlsxRow(XSSFRow row, List<Ingredient> ingredients) {
        return Recipe.builder()
                .recipeName(row.getCell(0).toString())
                .shortDescription(row.getCell(1).toString())
                .longDescription(row.getCell(2).toString())
                .meal(Meal.valueOf(row.getCell(3).toString().toUpperCase()))
                .ingredients(ingredients)
                .build();
    }

    /**
     * @return Meal
     * Method pull ingredient from row and save it a Meal entity.
     */
    private Ingredient loadRecipeIngredientFromXlsxRow(XSSFRow row) {
        return Ingredient.builder()
                .comestibleProduct(comestibleProductDao.get((long) row.getCell(4).getNumericCellValue()))
                .amount(row.getCell(5).getNumericCellValue())
                .ingredientUnit(IngredientUnit.valueOf(row.getCell(6).getStringCellValue().toUpperCase()))
                .build();
    }
}
