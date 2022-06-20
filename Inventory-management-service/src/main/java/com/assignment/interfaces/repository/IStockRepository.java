package com.assignment.interfaces.repository;

import com.assignment.entity.StockDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IStockRepository extends JpaRepository<StockDetailsEntity, String> {
    Optional<StockDetailsEntity> findByProductNameAndProductCategoryAndProductColor(String productName, String productCategory, String productColor);
}
