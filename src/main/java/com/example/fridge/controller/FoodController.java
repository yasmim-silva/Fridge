package com.example.fridge.controller;

import com.example.fridge.dto.FoodDTO;
import com.example.fridge.model.Category;
import com.example.fridge.model.Food;
import com.example.fridge.service.FoodService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food")
@Tag(name = "Geladeira", description = "Gerencie os itens da sua geladeira")
public class FoodController {

    @Autowired
    FoodService foodService;

    @GetMapping
    @Operation(summary = "Lista todos os itens da geladeira")
    public List<Food> getAll() {
        return foodService.getAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Busca um item pelo ID")
    public ResponseEntity<Food> getById(@PathVariable Long id) {
        return ResponseEntity.ok(foodService.getById(id));
    }

    @GetMapping("/search")
    @Operation(summary = "Busca itens pelo nome")
    public List<Food> search(@RequestParam String name) {
        return foodService.searchByName(name);
    }

    @GetMapping("/category/{category}")
    @Operation(summary = "Filtra itens por categoria")
    public List<Food> getByCategory(@PathVariable Category category) {
        return foodService.getByCategory(category);
    }

    @GetMapping("/shopping-list")
    @Operation(summary = "Lista itens esgotados")
    public List<Food> getShoppingList() {
        return foodService.getShoppingList();
    }

    @GetMapping("/low-stock")
    @Operation(summary = "Lista itens com estoque baixo.")
    public List<Food> getLowStock(@RequestParam(required = false) Integer threshold) {
        return foodService.getLowStock(threshold);
    }

    @GetMapping("/expired")
    @Operation(summary = "Lista itens vencidos")
    public List<Food> getExpired() {
        return foodService.getExpired();
    }

    @GetMapping("/expiring-soon")
    @Operation(summary = "Lista itens que vencem em breve.")
    public List<Food> getExpiringSoon(@RequestParam(defaultValue = "7") int days) {
        return foodService.getExpiringSoon(days);
    }

    @PostMapping
    @Operation(summary = "Adiciona um novo item à geladeira")
    public ResponseEntity<Food> create(@Valid @RequestBody Food food) {
        return ResponseEntity.status(HttpStatus.CREATED).body(foodService.save(food));
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Atualiza um item")
    public ResponseEntity<Food> update(@PathVariable Long id, @Valid @RequestBody FoodDTO dto) {
        return ResponseEntity.ok(foodService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remove um item da geladeira")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        foodService.delete(id);
        return ResponseEntity.noContent().build();
    }
}