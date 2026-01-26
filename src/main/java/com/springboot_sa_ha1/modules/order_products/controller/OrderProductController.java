package com.springboot_sa_ha1.modules.order_products.controller;

import com.springboot_sa_ha1.modules.order_products.dto.OrderProductRequest;
import com.springboot_sa_ha1.modules.order_products.dto.OrderProductResponse;
import com.springboot_sa_ha1.modules.order_products.service.OrderProductService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order_product")
public class OrderProductController {

  private final OrderProductService orderProductService;

  public OrderProductController(OrderProductService orderProductService) {
    this.orderProductService = orderProductService;
  }

  // Listar todos los order-products
  @GetMapping
  public ResponseEntity<List<OrderProductResponse>> listar() {
    return ResponseEntity.ok(orderProductService.listarTodos());
  }

  // Obtener order-product por su ID
  @GetMapping("/{id}")
  public ResponseEntity<OrderProductResponse> obtenerPorId(@PathVariable Long id) {
    return ResponseEntity.ok(orderProductService.obtenerPorId(id));
  }

  // Crear nuevo order-product
  @PostMapping
  public ResponseEntity<OrderProductResponse> crear(@Valid @RequestBody OrderProductRequest request) {
    return ResponseEntity.ok(orderProductService.guardar(request));
  }

  // Actualizar order-product por ID
  @PutMapping("/{id}")
  public ResponseEntity<OrderProductResponse> actualizar(
      @PathVariable Long id,
      @Valid @RequestBody OrderProductRequest request
  ) {
    return ResponseEntity.ok(orderProductService.actualizar(id, request));
  }

  // Eliminar order-product por ID
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> eliminar(@PathVariable Long id) {
    orderProductService.eliminar(id);
    return ResponseEntity.noContent().build();
  }
}
