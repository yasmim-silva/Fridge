package com.example.fridge.controller;

import com.example.fridge.model.Food;
import com.example.fridge.service.FoodService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodController {

    // injeção de dependência
    @Autowired
    FoodService foodService;

    // Pegar do servidor
    @GetMapping
    public List<Food> getAll() {
        return foodService.getAll();
    }

    // @PostMapping - Enviar informações
    // @RequestBody - pede para mandar, no corpo da requisição, os atributos do model.
    @PostMapping
    public Food create(@RequestBody Food food) {
        return foodService.save(food);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        foodService.delete(id);
    }
}
