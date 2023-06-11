package com.example.spring_security_1.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepo extends JpaRepository<Category, Long> {
    Category findByIdAndDeletedFalse(Long id);

    List<Category> findAllByDeletedFalse();

    @Query(value = "UPDATE category SET deleted = true WHERE id = ?1 AND deleted = false", nativeQuery = true)
    boolean delete(Long id);
}
