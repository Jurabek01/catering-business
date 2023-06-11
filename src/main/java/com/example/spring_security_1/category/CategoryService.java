package com.example.spring_security_1.category;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

        private final CategoryRepo categoryRepo;

        public Category findById(Long id) {
            return categoryRepo.findByIdAndDeletedFalse(id);
        }

        public Category save(Category category) {
            return categoryRepo.save(category);
        }

        public boolean delete(Long id) {
            return categoryRepo.delete(id);
        }

        public boolean update(Category category) {
            if (categoryRepo.findByIdAndDeletedFalse(category.getId()) != null) {
                categoryRepo.save(category);
                return true;
            }
            return false;
        }

        public List<Category> findAll() {
            return categoryRepo.findAllByDeletedFalse();
        }
}
