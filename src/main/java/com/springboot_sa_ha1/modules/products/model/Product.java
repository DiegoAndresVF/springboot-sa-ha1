package com.springboot_sa_ha1.modules.products.model;


import com.springboot_sa_ha1.modules.categories.model.Category;
import com.springboot_sa_ha1.modules.order_products.model.OrderProduct;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "productos")
@Getter
@Setter
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  private String name;

  @NotNull
  private Long price;

  private Long stock;

  @NotBlank
  private String description;

  private String imageUrl;

  private Long id_category;

  private Long id_collection;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "id_category", insertable = false, updatable = false)
  private Category category;

  @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
  private Set<OrderProduct> orderProducts = new HashSet<>();
}



