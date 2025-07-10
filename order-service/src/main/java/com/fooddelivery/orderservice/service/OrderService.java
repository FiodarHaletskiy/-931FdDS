package com.fooddelivery.orderservice.service;



import com.fooddelivery.orderservice.dto.OrderCreatedEvent;
import com.fooddelivery.orderservice.dto.OrderRequest;
import com.fooddelivery.orderservice.dto.OrderResponse;
import com.fooddelivery.orderservice.entity.Order;
import com.fooddelivery.orderservice.mapper.OrderMapper;
import com.fooddelivery.orderservice.repository.OrderRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.hibernate.ObjectNotFoundException;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final KafkaTemplate<String, OrderCreatedEvent> kafkaTemplate;

    @Transactional
    public OrderResponse createOrder(OrderRequest request, Long userId) {
        Order order = orderMapper.toEntity(request, userId);
        order.getItems().forEach(item -> item.setOrder(order));
        Order savedOrder = orderRepository.save(order);
        kafkaTemplate.send("order-created", new OrderCreatedEvent(savedOrder.getId(),savedOrder.getUserId(),
        savedOrder.getRestaurantId(),savedOrder.getItems(), savedOrder.getTotalPrice(),
        savedOrder.getCreatedAt()));
        return orderMapper.toResponse(savedOrder);
    }
    @Transactional
    public OrderResponse getOrder(Long orderId) throws ObjectNotFoundException {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new EntityNotFoundException("Order with id: "+orderId+" not found"));
        return orderMapper.toResponse(order);
    }
}