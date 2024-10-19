package com.team.revshop.repository;

import com.team.revshop.model.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BuyerRepo extends JpaRepository<Buyer, Integer> {

    Optional<Buyer> findByEmail(String email);
}
