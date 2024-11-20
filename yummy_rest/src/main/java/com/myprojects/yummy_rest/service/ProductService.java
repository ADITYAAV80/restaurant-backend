package org.myprojects.yummy_rest.service;

import lombok.RequiredArgsConstructor;
import org.myprojects.yummy_rest.dto.ProductRequest;
import org.myprojects.yummy_rest.dto.ProductResponse;
import org.myprojects.yummy_rest.entity.Product;
import org.myprojects.yummy_rest.exception.ProductAlreadyExistsException;
import org.myprojects.yummy_rest.exception.ProductNotFoundException;
import org.myprojects.yummy_rest.mapper.ProductMapper;
import org.myprojects.yummy_rest.repo.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepo repo;
    private final ProductMapper mapper;

    public ProductResponse createProduct(ProductRequest request) {
        if(repo.findByName(request.name()).orElse(null) != null) {
            throw new ProductAlreadyExistsException(format("Product with name %s already exists", request.name()));
        }
        Product product = mapper.toProduct(request);
        repo.save(product);

        return mapper.toProductResponse(product);
    }

    public List<ProductResponse> getAllProducts() {
        return mapper.toProductListResponse(repo.findAll());
    }

    public Product getProduct(Long id) {
        return repo.findById(id)
            .orElseThrow(() -> new ProductNotFoundException(
                format("No product with provided id: %d", id)
            ));
    }

    public ProductResponse retrieveProduct(Long id) {
        Product product = getProduct(id);
        return mapper.toProductResponse(product);
    }

    public String deleteProduct(Long id) {
        if(!repo.existsById(id)) {
            throw new ProductNotFoundException(format("No product with provided id: %d", id));
        }
        repo.deleteById(id);
        return "Product deleted";
    }

    public ProductResponse updateProduct(ProductRequest request, Long id) {
        if(!repo.existsById(id)) {
            throw new ProductNotFoundException(format("No product with provided id: %d", id));
        }
        Product product = mapper.toProduct(request);
        product.setId(id);
        repo.save(product);
        return mapper.toProductResponse(product);
    }

    public List<ProductResponse> getTopNProductsInPriceRangeXY(Long numProducts, double priceFrom, double priceTill) {
        return mapper.toProductListResponse(repo.findTopNProductsInPriceRangeXY(numProducts, priceFrom, priceTill));
    }
}
