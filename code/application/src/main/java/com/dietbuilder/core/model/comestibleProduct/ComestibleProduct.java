package com.dietbuilder.core.model.comestibleProduct;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class ComestibleProduct {

    private String id;

    private String productName;

    /**
     * measured in grams
     */
    private Double litter;
    /**
     * measured in kcal
     */
    private Integer foodEnergy;
    /**
     * measured in grams
     */
    private Double water;
    /**
     * measured in grams
     */
    private Double animalProtein;
    /**
     * measured in grams
     */
    private Double vegetableProtein;
    /**
     * measured in grams
     */
    private Double fat;
    /**
     * measured in grams
     */
    private Double ash;
    /**
     * measured in miligrams
     */
    private Double sodium;
    /**
     * measured in miligrams
     */
    private Double potassium;
    /**
     * measured in miligrams
     */
    private Double calcium;
    /**
     * measured in miligrams
     */
    private Double phosphorus;
    /**
     * measured in miligrams
     */
    private Double magnesium;
    /**
     * measured in miligrams
     */
    private Double iron;
    /**
     * measured in miligrams
     */
    private Double zinc;
    /**
     * measured in miligrams
     */
    private Double copper;
    /**
     * measured in miligrams
     */
    private Double manganese;
    /**
     * measured in micrograms
     * colloquially Vitamin A
     */
    private Double retinol;
    /**
     * measured in micrograms
     */
    private Double betaCarotene;
    /**
     * measured in micrograms
     */
    private Double vitaminD;
    /**
     * measured in miligrams
     */
    private Double vitaminE;
    /**
     * measured in miligrams
     * colloquially Vitamin B1
     */
    private Double thiamin;
    /**
     * measured in miligrams
     * colloquially Vitamin B2
     */
    private Double riboflavin;
    /**
     * measured in miligrams
     * colloquially Vitamin B3
     */
    private Double niacin;
    /**
     * measured in miligrams
     */
    private Double vitaminB6;
    /**
     * measured in micrograms
     */
    private Double folates;
    /**
     * measured in micrograms
     */
    private Double vitaminB12;
    /**
     * measured in micrograms
     */
    private Double vitaminC;
    /**
     * measured in grams
     */
    private Double saturatedFattyAcids;
    /**
     * measured in grams
     */
    private Double monounsaturatedFattyAcids;
    /**
     * measured in grams
     */
    private Double polyunsaturatedFattyAcids;
    /**
     * measured in miligrams
     */
    private Double cholesterol;
    /**
     * measured in miligrams
     */
    private Double isoleucine;
    /**
     * measured in miligrams
     */
    private Double leucin;
    /**
     * measured in miligrams
     */
    private Double lysine;
    /**
     * measured in miligrams
     */
    private Double methionine;
    /**
     * measured in miligrams
     */
    private Double cystine;
    /**
     * measured in miligrams
     */
    private Double phenylalanine;
    /**
     * measured in miligrams
     */
    private Double tyrosine;
    /**
     * measured in miligrams
     */
    private Double threonine;
    /**
     * measured in miligrams
     */
    private Double tryptophan;
    /**
     * measured in miligrams
     */
    private Double valine;
    /**
     * measured in miligrams
     */
    private Double arginine;
    /**
     * measured in miligrams
     */
    private Double histidine;
    /**
     * measured in miligrams
     */
    private Double alanine;
    /**
     * measured in miligrams
     */
    private Double asparticAcid;
    /**
     * measured in miligrams
     */
    private Double glutamicAcid;
    /**
     * measured in miligrams
     */
    private Double glycine;
    /**
     * measured in miligrams
     */
    private Double proline;
    /**
     * measured in miligrams
     */
    private Double serine;
    /**
     * measured in grams
     */
    private Double sucrose;
    /**
     * measured in grams
     */
    private Double lactose;
    /**
     * measured in grams
     */
    private Double starch;
    /**
     * measured in grams
     */
    private Double dietaryFibre;
    /**
     * measured in percents
     */
    private Double percentOfEnergyFromProtein;
    /**
     * measured in percents
     */
    private Double percentOfEnergyFromFat;
    /**
     * measured in percents
     */
    private Double percentOfEnergyFromCarbohydrates;

    /**
     * @return all proteins
     */
    public Double getProtein() {
        return (animalProtein + vegetableProtein);
    }

    /**
     * @return all carbohydrates
     */
    public Double allCarbohydrates() {
        return (lactose + sucrose + starch + dietaryFibre);
    }

    /**
     * @return all carbohydrates except dietary fibre
     */
    public Double allAssibilableCarbohydrates() {
        return (lactose + sucrose + starch);
    }
}

