package com.team.revshop.repository;

import com.team.revshop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

    List<Product> findBySellerId(int sellerId);
}
