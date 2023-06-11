package com.example.spring_security_1.food;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FoodRepo extends JpaRepository<Food, Long> {
    Food findByIdAndDeletedFalse(Long id);
    List<Food> findAllByDeletedFalse();

    @Query(value = "UPDATE food SET deleted = true WHERE id = ?1 AND deleted = false", nativeQuery = true)
    boolean delete(Long id);
}
