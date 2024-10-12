package com.dietbuilder.domain.repositories;

import com.dietbuilder.domain.model.comestible_product.ComestibleProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComestibleProductRepository extends JpaRepository<ComestibleProduct, Long> {
    List<ComestibleProduct> findAllByOrderByProductNameAsc();

    List<ComestibleProduct> findByProductNameContainsIgnoreCase(String productName);
}