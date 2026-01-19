package com.springboot_sa_ha1.orders.mapper;
import com.springboot_sa_ha1.orders.dto.OrderResponse;
import com.springboot_sa_ha1.orders.model.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {
  public OrderResponse toResponse(Order order) {
    return new OrderResponse(
        order.getId(),
        order.getQuantity(),
        order.getOrderDate(),
        order.getTotal(),
        order.getProductId(),
        order.getCustomerId()
    );
  }
}
