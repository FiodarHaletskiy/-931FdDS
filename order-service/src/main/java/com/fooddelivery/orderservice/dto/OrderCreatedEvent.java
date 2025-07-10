package com.fooddelivery.orderservice.dto;

import com.fooddelivery.orderservice.entity.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.Instant;
import java.util.List;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class OrderCreatedEvent{
        private Long orderId;
        private Long userId;
        private Long restaurantId;
        private  List<OrderItem> items;
        private Double totalPrice;
        private Instant createdAt;
}