package com.springboot_sa_ha1.modules.order_products.service;

import com.springboot_sa_ha1.modules.order_products.dto.OrderProductRequest;
import com.springboot_sa_ha1.modules.order_products.dto.OrderProductResponse;

import java.util.List;

public interface OrderProductService {

  List<OrderProductResponse> listarTodos();

  OrderProductResponse obtenerPorId(Long id);

  OrderProductResponse guardar(OrderProductRequest request);

  OrderProductResponse actualizar(Long id, OrderProductRequest request);

  void eliminar(Long id);
}