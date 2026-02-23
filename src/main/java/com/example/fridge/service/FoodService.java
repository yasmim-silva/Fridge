package com.example.fridge.service;

import com.example.fridge.dto.FoodDTO;
import com.example.fridge.exception.FoodNotFoundException;
import com.example.fridge.model.Category;
import com.example.fridge.model.Food;
import com.example.fridge.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class FoodService {

    @Autowired
    FoodRepository foodRepository;

    public List<Food> getAll() {
        return foodRepository.findAll();
    }

    public Food getById(Long id) {
        return foodRepository.findById(id)
                .orElseThrow(() -> new FoodNotFoundException(id));
    }

    public List<Food> getByCategory(Category category) {
        return foodRepository.findByCategory(category);
    }

    public List<Food> searchByName(String name) {
        return foodRepository.findByNameContainingIgnoreCase(name);
    }

    // Itens com quantidade = 0
    public List<Food> getShoppingList() {
        return foodRepository.findByQuantity(0);
    }

    // Itens com estoque baixo
    public List<Food> getLowStock(Integer limite) {
        return foodRepository.findLowStock(limite != null ? limite : 2);
    }

    // Itens vencidos
    public List<Food> getExpired() {
        return foodRepository.findExpiringBefore(LocalDate.now());
    }

    // Itens que vencem nos próximos dias
    public List<Food> getExpiringSoon(int days) {
        return foodRepository.findExpiringBefore(LocalDate.now().plusDays(days));
    }

    public Food save(Food food) {
        return foodRepository.save(food);
    }

    public Food update(Long id, FoodDTO dto) {
        Food food = getById(id);

        if (dto.getName() != null)           food.setName(dto.getName());
        if (dto.getQuantity() != null)        food.setQuantity(dto.getQuantity());
        if (dto.getExpirationDate() != null)  food.setExpirationDate(dto.getExpirationDate());
        if (dto.getCategory() != null)        food.setCategory(dto.getCategory());
        if (dto.getUnit() != null)            food.setUnit(dto.getUnit());

        return foodRepository.save(food);
    }

    public void delete(Long id) {
        if (!foodRepository.existsById(id)) throw new FoodNotFoundException(id);
        foodRepository.deleteById(id);
    }
}