package com.team.revshop.repository;

import com.team.revshop.model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SellerRepo extends JpaRepository<Seller, Integer> {

    Optional<Seller> findByEmail(String email); // Custom query to find seller by email
}
