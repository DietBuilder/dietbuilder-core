package com.dietbuilder.domain.model.diet;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.Hibernate;

@Builder(toBuilder = true)
@Entity
@Table(name = "diet")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Diet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    private DietStatus dietStatus;

    @OneToMany(mappedBy = "recipeId")
    private List<RecipeToDiet> recipeList;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Diet diet = (Diet) o;
        return id != null && Objects.equals(id, diet.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
