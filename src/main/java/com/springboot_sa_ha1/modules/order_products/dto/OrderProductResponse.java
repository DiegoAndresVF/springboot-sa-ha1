package com.springboot_sa_ha1.modules.order_products.dto;

public record OrderProductResponse (
  Long id,
  Integer quantity,
  Integer price
){}
