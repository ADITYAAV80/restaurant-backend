package org.myprojects.yummy_rest.repo;

import org.myprojects.yummy_rest.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
    Optional<Product> findByName(String name);

    @Query(
        "SELECT p " +
        "FROM Product p " +
        "WHERE p.price BETWEEN :priceFrom AND :priceTill " +
        "ORDER by p.price DESC " +
        "LIMIT :numProducts"
    )
    List<Product> findTopNProductsInPriceRangeXY(
            @Param("numProducts") Long numProducts,
            @Param("priceFrom") double priceFrom,
            @Param("priceTill") double priceTill
    );
}
