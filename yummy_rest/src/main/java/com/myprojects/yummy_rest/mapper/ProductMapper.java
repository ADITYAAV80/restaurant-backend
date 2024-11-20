package org.myprojects.yummy_rest.mapper;

import org.myprojects.yummy_rest.dto.ProductRequest;
import org.myprojects.yummy_rest.dto.ProductResponse;
import org.myprojects.yummy_rest.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductMapper {
    public Product toProduct(ProductRequest productRequest) {
        return Product.builder()
                .name(productRequest.name())
                .price(productRequest.price())
                .build();
    }

    public List<ProductResponse> toProductListResponse(List<Product> productList) {
        return productList.stream()
                .map(product -> new ProductResponse(
                        product.getId(),
                        product.getName(),
                        product.getPrice()
                ))
                .toList();
    }

    public ProductResponse toProductResponse(Product product) {
        return new ProductResponse(product.getId(), product.getName(), product.getPrice());
    }
}
