package com.example.spring_security_1.order;

import com.example.spring_security_1.order.address.OrdersAddress;
import com.example.spring_security_1.order.price.OrderPrice;
import com.example.spring_security_1.user.User;
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
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userPhone;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private String foods;
    @OneToOne
    @JoinColumn(name = "address_id")
    private OrdersAddress address;
    @OneToOne
    @JoinColumn(name = "price_id")
    private OrderPrice price;

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
