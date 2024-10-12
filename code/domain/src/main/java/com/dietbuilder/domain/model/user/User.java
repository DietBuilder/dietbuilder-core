package com.dietbuilder.domain.model.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "`user`")
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userId")
    private long userId;

    private Gender gender;

    private Double height;

    private Double weight;

    private Integer age;

    private Double psychicalActivityRatio;

    private Double basalEnergyExpenditure;

    private Double totalEnergyExpenditure;

    private Integer numberOfMeals;

    private UserGoal userGoal;

    private Long dietId;

    @OneToMany(mappedBy = "userId")
    private List<UnwantedComestibleProducts> unwantedComestibleProducts;
}
