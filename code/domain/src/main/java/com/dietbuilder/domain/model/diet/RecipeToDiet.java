package com.dietbuilder.domain.model.diet;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder(toBuilder = true)
@Entity
@Table(name = "recipe_to_diet")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class RecipeToDiet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "recipeId")
    private Long recipeId;

    private int mealNumber;

    @ManyToOne
    @JoinColumn(name = "dietId", nullable = false)
    private Diet dietId;
}
