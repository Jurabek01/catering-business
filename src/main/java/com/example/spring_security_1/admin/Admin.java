package com.example.spring_security_1.admin;

import com.example.spring_security_1.utils.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@Entity
@Builder
@Table(name = "admin")
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String phone;
    private String password;
    private String firstName;
    private String lastName;
    private Set<Role> roles;

    @Builder.Default
    private Boolean deleted = false;

    @Column(name = "created", updatable = false)
    private LocalDateTime created;

    @Column(name = "updated")
    private LocalDateTime updated;

    @PrePersist // вызывается перед сохранением новой сущности в базе данных
    public void prePersist() {
        this.created = LocalDateTime.now();
    }

    @PreUpdate // вызывается перед обновлением существующей сущности в базе данных
    public void preUpdate() {
        this.updated = LocalDateTime.now();
    }
}
