package com.fooddelivery.orderservice.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = false)
    private Long userId;
    @Column(nullable = false, unique = false)
    private Long restaurantId;
    @Column(nullable = false, unique = false)
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    @Column(nullable = false, unique = false)
    private Double totalPrice;
    @Column(nullable = false, unique = false)
    @CreationTimestamp
    private Instant createdAt;
    @Column(nullable = false, unique = false)
    @UpdateTimestamp
    private Instant updatedAt;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<OrderItem> items = new ArrayList<>();
}