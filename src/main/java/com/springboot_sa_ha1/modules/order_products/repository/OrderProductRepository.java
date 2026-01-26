package com.springboot_sa_ha1.modules.order_products.repository;

import com.springboot_sa_ha1.modules.order_products.model.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderProductRepository extends JpaRepository<OrderProduct, Long> {  // ¡Objeto como ID!
  boolean existsByOrderIdAndProductId(Long orderId, Long productId);
}