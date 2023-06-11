package com.example.spring_security_1.food;

import com.example.spring_security_1.category.Category;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "food")
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameUz;
    private String nameRu;
    private String nameEn;
    private String descriptionUz;
    private String descriptionRu;
    private String descriptionEn;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    private Long price;
    private String image;

    @Builder.Default // если не указано, то будет использоваться значение по умолчанию
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
