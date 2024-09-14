package org.example.petproj.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;


@Entity
@Table(name = "recipes")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="cheese_name")
    @Pattern(regexp = "[а-яА-я ]+", message = "Имя не дожно содержать символов кроме русских букв и пробелов")
    private String cheeseName;

    @Column(name="material_name")
    private String materialName;

    @Column(name="amount_of_material")
    @Min(value = 1, message = "Введите положительное целое число")
    private int amountOfMaterialRequired;


    public Recipe() {}

    public String getCheeseName() {
        return cheeseName;
    }

    public void setCheeseName(String cheeseName) {
        this.cheeseName = cheeseName;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public int getAmountOfMaterialRequired() {
        return amountOfMaterialRequired;
    }

    public void setAmountOfMaterialRequired(int amountOfMaterialRequired) {
        this.amountOfMaterialRequired = amountOfMaterialRequired;
    }

    public Long getId() {
        return id;
    }
}
