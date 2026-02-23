package com.example.fridge.repository;

import com.example.fridge.model.Category;
import com.example.fridge.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface FoodRepository extends JpaRepository<Food, Long> {

    List<Food> findByCategory(Category category);

    List<Food> findByQuantity(Integer quantity);

    List<Food> findByNameContainingIgnoreCase(String name);

    // Itens vencidos ou próximos do vencimento
    @Query("SELECT f FROM Food f WHERE f.expirationDate <= :date")
    List<Food> findExpiringBefore(@Param("date") LocalDate date);

    // Itens com estoque baixo (quantidade <= limite)
    @Query("SELECT f FROM Food f WHERE f.quantity <= :limite AND f.quantity > 0")
    List<Food> findLowStock(@Param("limite") Integer limite);
}