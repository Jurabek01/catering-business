package com.example.spring_security_1.category;

import com.example.spring_security_1.food.Food;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameUz;
    private String nameRu;
    private String nameEn;
    private String descriptionUz;
    private String descriptionRu;
    private String descriptionEn;
    private String image;
    @OneToMany(mappedBy = "category")
    @JoinColumn(name = "food_id")
    private List<Food> foods;
    @Builder.Default
    private Boolean deleted;
    @Column(name = "created", updatable = false)
    private LocalDateTime created;
    @Column(name = "updated")
    private LocalDateTime updated;

    @PrePersist
    public void prePersist() {
        this.created = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.updated = LocalDateTime.now();
    }
}
