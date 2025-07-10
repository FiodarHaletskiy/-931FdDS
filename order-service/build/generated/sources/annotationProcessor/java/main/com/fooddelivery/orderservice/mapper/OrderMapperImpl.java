package com.fooddelivery.orderservice.mapper;

import com.fooddelivery.orderservice.dto.OrderItemRequest;
import com.fooddelivery.orderservice.dto.OrderItemResponse;
import com.fooddelivery.orderservice.dto.OrderRequest;
import com.fooddelivery.orderservice.dto.OrderResponse;
import com.fooddelivery.orderservice.entity.Order;
import com.fooddelivery.orderservice.entity.OrderItem;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-08T16:01:05+0300",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.14.2.jar, environment: Java 21.0.7 (Microsoft)"
)
@Component
public class OrderMapperImpl implements OrderMapper {

    @Override
    public Order toEntity(OrderRequest request, Long userId) {
        if ( request == null ) {
            return null;
        }

        Order.OrderBuilder order = Order.builder();

        order.userId( request.getUserId() );
        order.restaurantId( request.getRestaurantId() );
        order.status( request.getStatus() );
        order.totalPrice( request.getTotalPrice() );
        order.items( orderItemRequestListToOrderItemList( request.getItems(), userId ) );

        return order.build();
    }

    @Override
    public OrderResponse toResponse(Order order) {
        if ( order == null ) {
            return null;
        }

        OrderResponse.OrderResponseBuilder orderResponse = OrderResponse.builder();

        orderResponse.id( order.getId() );
        orderResponse.userId( order.getUserId() );
        orderResponse.restaurantId( order.getRestaurantId() );
        orderResponse.status( order.getStatus() );
        orderResponse.totalPrice( order.getTotalPrice() );
        orderResponse.createdAt( order.getCreatedAt() );
        orderResponse.updatedAt( order.getUpdatedAt() );
        orderResponse.items( orderItemListToOrderItemResponseList( order.getItems() ) );

        return orderResponse.build();
    }

    protected OrderItem orderItemRequestToOrderItem(OrderItemRequest orderItemRequest, Long userId) {
        if ( orderItemRequest == null ) {
            return null;
        }

        OrderItem.OrderItemBuilder orderItem = OrderItem.builder();

        orderItem.dishId( orderItemRequest.getDishId() );
        orderItem.quantity( orderItemRequest.getQuantity() );

        return orderItem.build();
    }

    protected List<OrderItem> orderItemRequestListToOrderItemList(List<OrderItemRequest> list, Long userId) {
        if ( list == null ) {
            return null;
        }

        List<OrderItem> list1 = new ArrayList<OrderItem>( list.size() );
        for ( OrderItemRequest orderItemRequest : list ) {
            list1.add( orderItemRequestToOrderItem( orderItemRequest, userId ) );
        }

        return list1;
    }

    protected OrderItemResponse orderItemToOrderItemResponse(OrderItem orderItem) {
        if ( orderItem == null ) {
            return null;
        }

        OrderItemResponse.OrderItemResponseBuilder orderItemResponse = OrderItemResponse.builder();

        orderItemResponse.id( orderItem.getId() );
        orderItemResponse.dishId( orderItem.getDishId() );
        orderItemResponse.dishName( orderItem.getDishName() );
        orderItemResponse.price( orderItem.getPrice() );
        orderItemResponse.quantity( orderItem.getQuantity() );

        return orderItemResponse.build();
    }

    protected List<OrderItemResponse> orderItemListToOrderItemResponseList(List<OrderItem> list) {
        if ( list == null ) {
            return null;
        }

        List<OrderItemResponse> list1 = new ArrayList<OrderItemResponse>( list.size() );
        for ( OrderItem orderItem : list ) {
            list1.add( orderItemToOrderItemResponse( orderItem ) );
        }

        return list1;
    }
}
