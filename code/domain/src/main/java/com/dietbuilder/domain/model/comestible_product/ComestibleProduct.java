package com.dietbuilder.domain.model.comestible_product;

import com.dietbuilder.domain.model.recipe.Ingredient;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "comestible_product")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ComestibleProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;

    @Column(name = "PRODUCT_NAME", unique = true)
    private String productName;

    /**
     * ingredients hold detail data connected with concrete product
     */
    @OneToMany(mappedBy = "comestibleProduct",
            orphanRemoval = true)
    @JsonBackReference
    private List<Ingredient> ingredients = new ArrayList<>();

    /**
     * measured in grams
     */
    @Column(name = "LITTER")
    private Double litter;

    /**
     * measured in kcal
     */
    @Column(name = "FOOD_ENERGY")
    private Integer foodEnergy;

    /**
     * measured in grams
     */
    @Column(name = "WATER")
    private Double water;

    /**
     * measured in grams
     */
    @Column(name = "ANIMAL_PROTEIN")
    private Double animalProtein;

    /**
     * measured in grams
     */
    @Column(name = "VEGETABLE_PROTEIN")
    private Double vegetableProtein;

    /**
     * measured in grams
     */
    @Column(name = "FAT")
    private Double fat;

    /**
     * measured in grams
     */
    @Column(name = "ASH")
    private Double ash;

    /**
     * measured in miligrams
     */
    @Column(name = "SODIUM")
    private Double sodium;

    /**
     * measured in miligrams
     */
    @Column(name = "POTASSIUM")
    private Double potassium;

    /**
     * measured in miligrams
     */
    @Column(name = "CALCIUM")
    private Double calcium;
    /**
     * measured in miligrams
     */
    @Column(name = "PHOSPHORUS")
    private Double phosphorus;

    /**
     * measured in miligrams
     */
    @Column(name = "MAGNESIUM")
    private Double magnesium;

    /**
     * measured in miligrams
     */
    @Column(name = "IRON")
    private Double iron;

    /**
     * measured in miligrams
     */
    @Column(name = "ZINC")
    private Double zinc;

    /**
     * measured in miligrams
     */
    @Column(name = "COPPER")
    private Double copper;

    /**
     * measured in miligrams
     */
    @Column(name = "MANGANESE")
    private Double manganese;

    /**
     * measured in micrograms
     * colloquially Vitamin A
     */
    @Column(name = "RETINOL")
    private Double retinol;

    /**
     * measured in micrograms
     */
    @Column(name = "BETA_CAROTENE")
    private Double betaCarotene;

    /**
     * measured in micrograms
     */
    @Column(name = "VITAMIN_D")
    private Double vitaminD;

    /**
     * measured in miligrams
     */
    @Column(name = "VITAMIN_E")
    private Double vitaminE;

    /**
     * measured in miligrams
     * colloquially Vitamin B1
     */
    @Column(name = "THIAMIN")
    private Double thiamin;

    /**
     * measured in miligrams
     * colloquially Vitamin B2
     */
    @Column(name = "RIBOFLAVIN")
    private Double riboflavin;

    /**
     * measured in miligrams
     * colloquially Vitamin B3
     */
    @Column(name = "NIACIN")
    private Double niacin;

    /**
     * measured in miligrams
     */
    @Column(name = "VITAMIN_B6")
    private Double vitaminB6;

    /**
     * measured in micrograms
     */
    @Column(name = "FOLATES")
    private Double folates;

    /**
     * measured in micrograms
     */
    @Column(name = "VITAMIN_B12")
    private Double vitaminB12;

    /**
     * measured in micrograms
     */
    @Column(name = "VITAMIN_C")
    private Double vitaminC;

    /**
     * measured in grams
     */
    @Column(name = "SATURATED_FATTY_ACIDS")
    private Double saturatedFattyAcids;

    /**
     * measured in grams
     */
    @Column(name = "MONOUNSATURATED_FATTY_ACIDS")
    private Double monounsaturatedFattyAcids;

    /**
     * measured in grams
     */
    @Column(name = "POLYUNSATURATED_FATTY_ACIDS")
    private Double polyunsaturatedFattyAcids;

    /**
     * measured in miligrams
     */
    @Column(name = "CHOLESTEROL")
    private Double cholesterol;

    /**
     * measured in miligrams
     */
    @Column(name = "ISOLEUCINE")
    private Double isoleucine;


    /**
     * measured in miligrams
     */
    @Column(name = "LEUCIN")
    private Double leucin;

    /**
     * measured in miligrams
     */
    @Column(name = "LYSINE")
    private Double lysine;

    /**
     * measured in miligrams
     */
    @Column(name = "METHIONINE")
    private Double methionine;

    /**
     * measured in miligrams
     */
    @Column(name = "CYSTINE")
    private Double cystine;

    /**
     * measured in miligrams
     */
    @Column(name = "PHENYLALANINE")
    private Double phenylalanine;

    /**
     * measured in miligrams
     */
    @Column(name = "TYROSINE")
    private Double tyrosine;

    /**
     * measured in miligrams
     */
    @Column(name = "THREONINE")
    private Double threonine;

    /**
     * measured in miligrams
     */
    @Column(name = "TRYPTOPHAN")
    private Double tryptophan;

    /**
     * measured in miligrams
     */
    @Column(name = "VALINE")
    private Double valine;

    /**
     * measured in miligrams
     */
    @Column(name = "ARGININE")
    private Double arginine;

    /**
     * measured in miligrams
     */
    @Column(name = "HISTIDINE")
    private Double histidine;

    /**
     * measured in miligrams
     */
    @Column(name = "ALANINE")
    private Double alanine;

    /**
     * measured in miligrams
     */
    @Column(name = "ASPARTIC_ACID")
    private Double asparticAcid;

    /**
     * measured in miligrams
     */
    @Column(name = "GLUTAMIC_ACID")
    private Double glutamicAcid;

    /**
     * measured in miligrams
     */
    @Column(name = "GLYCINE")
    private Double glycine;

    /**
     * measured in miligrams
     */
    @Column(name = "PROLINE")
    private Double proline;

    /**
     * measured in miligrams
     */
    @Column(name = "SERINE")
    private Double serine;

    /**
     * measured in grams
     */
    @Column(name = "SUCROSE")
    private Double sucrose;

    /**
     * measured in grams
     */
    @Column(name = "LACTOSE")
    private Double lactose;

    /**
     * measured in grams
     */
    @Column(name = "STARCH")
    private Double starch;

    /**
     * measured in grams
     */
    @Column(name = "SIETARY_FIBRE")
    private Double dietaryFibre;

    /**
     * measured in percents
     */
    @Column(name = "PERCENT_OF_ENERGY_FROM_PROTEIN")
    private Double percentOfEnergyFromProtein;

    /**
     * measured in percents
     */
    @Column(name = "PERCENT_OF_ENERGY_FROM_FAT")
    private Double percentOfEnergyFromFat;

    /**
     * measured in percents
     */
    @Column(name = "PERCENT_OF_ENERGY_FROM_CABROHYDRATES")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComestibleProduct that = (ComestibleProduct) o;
        return id == that.id && Double.compare(that.litter, litter) == 0 && foodEnergy == that.foodEnergy && Double.compare(that.water, water) == 0 && Double.compare(that.animalProtein, animalProtein) == 0 && Double.compare(that.vegetableProtein, vegetableProtein) == 0 && Double.compare(that.fat, fat) == 0 && Double.compare(that.ash, ash) == 0 && Double.compare(that.sodium, sodium) == 0 && Double.compare(that.potassium, potassium) == 0 && Double.compare(that.calcium, calcium) == 0 && Double.compare(that.phosphorus, phosphorus) == 0 && Double.compare(that.magnesium, magnesium) == 0 && Double.compare(that.iron, iron) == 0 && Double.compare(that.zinc, zinc) == 0 && Double.compare(that.copper, copper) == 0 && Double.compare(that.manganese, manganese) == 0 && Double.compare(that.retinol, retinol) == 0 && Double.compare(that.betaCarotene, betaCarotene) == 0 && Double.compare(that.vitaminD, vitaminD) == 0 && Double.compare(that.vitaminE, vitaminE) == 0 && Double.compare(that.thiamin, thiamin) == 0 && Double.compare(that.riboflavin, riboflavin) == 0 && Double.compare(that.niacin, niacin) == 0 && Double.compare(that.vitaminB6, vitaminB6) == 0 && Double.compare(that.folates, folates) == 0 && Double.compare(that.vitaminB12, vitaminB12) == 0 && Double.compare(that.vitaminC, vitaminC) == 0 && Double.compare(that.saturatedFattyAcids, saturatedFattyAcids) == 0 && Double.compare(that.monounsaturatedFattyAcids, monounsaturatedFattyAcids) == 0 && Double.compare(that.polyunsaturatedFattyAcids, polyunsaturatedFattyAcids) == 0 && Double.compare(that.cholesterol, cholesterol) == 0 && Double.compare(that.isoleucine, isoleucine) == 0 && Double.compare(that.leucin, leucin) == 0 && Double.compare(that.lysine, lysine) == 0 && Double.compare(that.methionine, methionine) == 0 && Double.compare(that.cystine, cystine) == 0 && Double.compare(that.phenylalanine, phenylalanine) == 0 && Double.compare(that.tyrosine, tyrosine) == 0 && Double.compare(that.threonine, threonine) == 0 && Double.compare(that.tryptophan, tryptophan) == 0 && Double.compare(that.valine, valine) == 0 && Double.compare(that.arginine, arginine) == 0 && Double.compare(that.histidine, histidine) == 0 && Double.compare(that.alanine, alanine) == 0 && Double.compare(that.asparticAcid, asparticAcid) == 0 && Double.compare(that.glutamicAcid, glutamicAcid) == 0 && Double.compare(that.glycine, glycine) == 0 && Double.compare(that.proline, proline) == 0 && Double.compare(that.serine, serine) == 0 && Double.compare(that.sucrose, sucrose) == 0 && Double.compare(that.lactose, lactose) == 0 && Double.compare(that.starch, starch) == 0 && Double.compare(that.dietaryFibre, dietaryFibre) == 0 && Double.compare(that.percentOfEnergyFromProtein, percentOfEnergyFromProtein) == 0 && Double.compare(that.percentOfEnergyFromFat, percentOfEnergyFromFat) == 0 && Double.compare(that.percentOfEnergyFromCarbohydrates, percentOfEnergyFromCarbohydrates) == 0 && Objects.equals(productName, that.productName) && Objects.equals(ingredients, that.ingredients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productName, ingredients, litter, foodEnergy, water, animalProtein, vegetableProtein, fat, ash, sodium, potassium, calcium, phosphorus, magnesium, iron, zinc, copper, manganese, retinol, betaCarotene, vitaminD, vitaminE, thiamin, riboflavin, niacin, vitaminB6, folates, vitaminB12, vitaminC, saturatedFattyAcids, monounsaturatedFattyAcids, polyunsaturatedFattyAcids, cholesterol, isoleucine, leucin, lysine, methionine, cystine, phenylalanine, tyrosine, threonine, tryptophan, valine, arginine, histidine, alanine, asparticAcid, glutamicAcid, glycine, proline, serine, sucrose, lactose, starch, dietaryFibre, percentOfEnergyFromProtein, percentOfEnergyFromFat, percentOfEnergyFromCarbohydrates);
    }
}
