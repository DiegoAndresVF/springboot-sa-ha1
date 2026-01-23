package com.springboot_sa_ha1.modules.products.mapper;
import com.springboot_sa_ha1.modules.products.dto.ProductResponse;
import com.springboot_sa_ha1.modules.products.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public ProductResponse toResponse(Product product) {
        return new ProductResponse(
                product.getId(),                       // Long id_product
                product.getName(),                     // String product_name
                product.getPrice(),                    // Long price
                product.getStock(),                    // Long stock
                product.getDescription(),              // String description
                product.getImageUrl(),                 // String imageUrl
                product.getId_category(),              // Long id_category
                product.getCategory() != null
                        ? product.getCategory().getCategory_name()
                        : null,                            // String category_name
                product.getId_collection()             // Long id_collection
        );

    }
}
