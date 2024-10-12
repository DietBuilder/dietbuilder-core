package com.dietbuilder.domain.model.recipe;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "recipes")
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;

    @OneToMany(mappedBy = "recipe",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER)
//    @JsonManagedReference
    private List<Ingredient> ingredients = new ArrayList<>();

    @Column(name = "RECIPE_NAME", unique = true)
    private String recipeName;

    @Column(name = "SHORT_DESCRIPTION", columnDefinition = "LONGTEXT NOT NULL")
    private String shortDescription;

    @Column(name = "LONG_DESCRIPTION", columnDefinition = "LONGTEXT NOT NULL")
    private String longDescription;

    @Column(name = "MEAL")
    private Meal meal;
}


