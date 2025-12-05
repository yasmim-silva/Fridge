package com.example.fridge.service;

import com.example.fridge.model.Food;
import com.example.fridge.repository.FoodRepository;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.List;

@Service
public class FoodService {

    @Autowired
    FoodRepository foodRepository;

    // LISTAR
    public List<Food> getAll() {return foodRepository.findAll();}

    // CRIAR
    public Food save(Food food) {return  foodRepository.save(food);}

    //DELETAR
    public void delete(Long id) {foodRepository.deleteById(id);}



}
