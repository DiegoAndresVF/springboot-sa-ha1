package com.springboot_sa_ha1.orders.service;

import com.springboot_sa_ha1.orders.dto.OrderRequest;
import com.springboot_sa_ha1.orders.dto.OrderResponse;

import java.util.List;
import java.util.Optional;

public interface OrderService {
  List< OrderResponse> listarTodos();
  OrderResponse obtenerPorId(Long id);
  OrderResponse guardar(OrderRequest request);
  OrderResponse actualizar(Long id, OrderRequest request);
  void eliminar(Long id);
}