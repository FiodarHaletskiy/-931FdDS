package com.fooddelivery.orderservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Request data for a single order item")
public class OrderItemRequest {
    @NotNull
    @Schema(description = "ID of the dish being ordered", example = "15", required = true)
    private Long dishId;
    @NotNull
    @Min(1)
    @Schema(description = "Quantity of the dish", example = "2", minimum = "1", required = true)
    private Integer quantity;
}

