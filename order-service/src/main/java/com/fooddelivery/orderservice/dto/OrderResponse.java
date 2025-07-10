package com.fooddelivery.orderservice.dto;

import com.fooddelivery.orderservice.entity.OrderStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.Instant;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Response data for an order")
public class OrderResponse {

    @Schema(description = "Order ID", example = "1001")
    private Long id;

    @Schema(description = "User ID", example = "42")
    private Long userId;

    @Schema(description = "Restaurant ID", example = "10")
    private Long restaurantId;

    @Schema(description = "Order status", example = "COMPLETED")
    private OrderStatus status;

    @Schema(description = "Total price of the order", example = "79.99")
    private Double totalPrice;

    @Schema(description = "Timestamp of order creation", example = "2025-07-07T10:00:00Z")
    private Instant createdAt;

    @Schema(description = "Timestamp of last update", example = "2025-07-07T12:30:00Z")
    private Instant updatedAt;

    @Schema(description = "List of items in the order")
    private List<OrderItemResponse> items;
}