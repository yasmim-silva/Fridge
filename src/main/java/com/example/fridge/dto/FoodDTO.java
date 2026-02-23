package com.example.fridge.dto;

import com.example.fridge.model.Category;
import com.example.fridge.model.Food;
import jakarta.validation.constraints.Min;
import lombok.Data;

import java.time.LocalDate;

@Data
public class FoodDTO {

    private String name;

    @Min(value = 0, message = "A quantidade não pode ser negativa")
    private Integer quantity;

    private LocalDate expirationDate;

    private Category category;

    private String unit;
}