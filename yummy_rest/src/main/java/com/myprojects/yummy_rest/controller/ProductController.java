package org.myprojects.yummy_rest.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.myprojects.yummy_rest.dto.ProductRequest;
import org.myprojects.yummy_rest.dto.ProductResponse;
import org.myprojects.yummy_rest.exception.ProductAlreadyExistsException;
import org.myprojects.yummy_rest.exception.ProductNotFoundException;
import org.myprojects.yummy_rest.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(@RequestBody @Valid ProductRequest request) {
        try {
            ProductResponse response = productService.createProduct(request);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (ProductAlreadyExistsException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProduct(@PathVariable("id") Long id) {
        try {
            ProductResponse response = productService.retrieveProduct(id);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (ProductNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long id) {
        try {
            String response = productService.deleteProduct(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (ProductNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> updateProduct(
            @PathVariable("id") Long id, @RequestBody @Valid ProductRequest request
    ) {
        try {
            ProductResponse response = productService.updateProduct(request, id);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (ProductNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/query")
    public ResponseEntity<List<ProductResponse>> getTopNProductsInPriceRangeXY(
            @RequestParam Long numProducts, @RequestParam double priceFrom, @RequestParam double priceTill
    ) {
        return ResponseEntity.ok(productService.getTopNProductsInPriceRangeXY(numProducts, priceFrom, priceTill));
    }
}
