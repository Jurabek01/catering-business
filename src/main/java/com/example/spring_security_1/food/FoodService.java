package com.example.spring_security_1.food;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodService {

    private final FoodRepo foodRepo;

    public Food findById(Long id) {
        return foodRepo.findByIdAndDeletedFalse(id);
    }

    public Food save(Food food) {
        return foodRepo.save(food);
    }

    public boolean delete(Long id) {
        return foodRepo.delete(id);
    }

    public boolean update(Food food) {
        if (foodRepo.findByIdAndDeletedFalse(food.getId()) != null) {
            foodRepo.save(food);
            return true;
        }
        return false;
    }

    public List<Food> findAll() {
        return foodRepo.findAllByDeletedFalse();
    }
}
