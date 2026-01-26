package com.springboot_sa_ha1.modules.order_products.service;

import com.springboot_sa_ha1.modules.order_products.dto.OrderProductRequest;
import com.springboot_sa_ha1.modules.order_products.dto.OrderProductResponse;
import com.springboot_sa_ha1.modules.order_products.mapper.OrderProductMapper;
import com.springboot_sa_ha1.modules.order_products.model.OrderProduct;
import com.springboot_sa_ha1.modules.order_products.repository.OrderProductRepository;
import com.springboot_sa_ha1.modules.orders.model.Order;
import com.springboot_sa_ha1.modules.orders.repository.OrderRepository;
import com.springboot_sa_ha1.modules.products.model.Product;
import com.springboot_sa_ha1.modules.products.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderProductServiceImp implements OrderProductService {

  private final OrderProductRepository repository;
  private final OrderProductMapper mapper;
  private final ProductRepository productRepository;
  private final OrderRepository orderRepository;

  public OrderProductServiceImp(
      OrderProductRepository repository,
      ProductRepository productRepository,
      OrderRepository orderRepository,
      OrderProductMapper mapper
  ) {
    this.repository = repository;
    this.mapper = mapper;
    this.productRepository = productRepository;
    this.orderRepository = orderRepository;
  }

  @Override
  public List<OrderProductResponse> listarTodos() {
    return repository.findAll().stream()
        .map(mapper::toResponse)
        .toList();
  }

  @Override
  public OrderProductResponse obtenerPorId(Long id) {
    return repository.findById(id)
        .map(mapper::toResponse)
        .orElseThrow(() -> new RuntimeException("Order-Product no encontrado"));
  }

  @Override
  public OrderProductResponse guardar(OrderProductRequest request) {
    // Validar existencia de Order y Product
    Order order = orderRepository.findById(request.orderId())
        .orElseThrow(() -> new RuntimeException("Order no existe"));
    Product product = productRepository.findById(request.productId())
        .orElseThrow(() -> new RuntimeException("Product no existe"));

    // Verificar si ya existe la relación
    if (repository.existsByOrderIdAndProductId(request.orderId(), request.productId())) {
      throw new RuntimeException("El producto ya está asociado a la orden");
    }

    OrderProduct orderProduct = new OrderProduct();
    orderProduct.setOrder(order);
    orderProduct.setProduct(product);
    orderProduct.setQuantity(request.quantity());
    orderProduct.setPrice(request.price());

    return mapper.toResponse(repository.save(orderProduct));
  }

  @Override
  public OrderProductResponse actualizar(Long id, OrderProductRequest request) {
    OrderProduct orderProduct = repository.findById(id)
        .orElseThrow(() -> new RuntimeException("Order-Product no encontrado"));

    orderProduct.setQuantity(request.quantity());
    orderProduct.setPrice(request.price());

    return mapper.toResponse(repository.save(orderProduct));
  }

  @Override
  public void eliminar(Long id) {
    if (!repository.existsById(id)) {
      throw new RuntimeException("Order-Product no encontrado");
    }
    repository.deleteById(id);
  }
}

