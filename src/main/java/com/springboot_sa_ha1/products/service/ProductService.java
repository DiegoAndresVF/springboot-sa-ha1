package com.springboot_sa_ha1.products.service;

import com.springboot_sa_ha1.products.dto.ProductRequest;
import com.springboot_sa_ha1.products.dto.ProductResponse;
import com.springboot_sa_ha1.products.model.Product;

import java.util.List;

public interface ProductService {
    List<ProductResponse> listarTodos();
    ProductResponse obtenerPorId(Long id);
    ProductResponse guardar(ProductRequest request);
    ProductResponse actualizar(Long id, ProductRequest request);
    void eliminar(Long id);
}