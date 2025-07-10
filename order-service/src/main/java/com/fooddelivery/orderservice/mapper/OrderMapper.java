package com.fooddelivery.orderservice.mapper;

import com.fooddelivery.orderservice.dto.OrderRequest;
import com.fooddelivery.orderservice.dto.OrderResponse;
import com.fooddelivery.orderservice.entity.Order;
import com.fooddelivery.orderservice.entity.OrderStatus;

import lombok.Builder;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")

public interface OrderMapper {

    @Mapping(target = "items.order", ignore = true)
    Order toEntity(OrderRequest request, @Context Long userId);

    OrderResponse toResponse(Order order);

    @Named("statusToString")
    default String statusToString(OrderStatus status) {
        return status.name();
    }
}