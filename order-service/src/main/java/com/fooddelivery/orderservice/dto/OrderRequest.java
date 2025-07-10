package com.fooddelivery.orderservice.dto;

import com.fooddelivery.orderservice.entity.Order;
import com.fooddelivery.orderservice.entity.OrderItem;
import com.fooddelivery.orderservice.entity.OrderStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.Instant;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Request data for creating or updating an order")
public class OrderRequest {

    @NotNull
    @Schema(description = "ID of the user placing the order", example = "42", required = true)
    private Long userId;

    @NotNull
    @Schema(description = "ID of the restaurant", example = "10", required = true)
    private Long restaurantId;

    @NotNull
    @Schema(description = "Order status", example = "PENDING", required = true)
    private OrderStatus status;

    @NotNull
    @Schema(description = "Dish price", example = "154.2", required = true)
    private Double totalPrice;
    @NotNull
    @Schema(description = "List of order items", required = true)
    private List<OrderItemRequest> items;
}
