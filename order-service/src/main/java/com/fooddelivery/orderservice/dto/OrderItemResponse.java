package com.fooddelivery.orderservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Response data for a single order item")
public class OrderItemResponse {

    @Schema(description = "ID of the order item", example = "501")
    private Long id;

    @Schema(description = "ID of the dish", example = "15")
    private Long dishId;

    @Schema(description = "Name of the dish", example = "Margherita Pizza")
    private String dishName;

    @Schema(description = "Price per unit of the dish", example = "12.50")
    private Double price;

    @Schema(description = "Quantity of the dish ordered", example = "2")
    private Integer quantity;
}