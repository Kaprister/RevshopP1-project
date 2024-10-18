package com.team.revshop.service;

import com.team.revshop.model.Seller;
import com.team.revshop.repository.SellerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

@Service
public class SellerService {
    @Autowired
    private SellerRepo sellerRepo;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    //    seller signup feature
    public Seller signUp(Seller seller) throws Exception{
        // Check if seller with the same email exists
        if (sellerRepo.findByEmail(seller.getEmail()).isPresent()) {
            throw new Exception("Email already exists.");
        }
        // Encrypt the password before saving
        seller.setPassword(passwordEncoder.encode(seller.getPassword()));

        return sellerRepo.save(seller);
    }

    public Seller login(Seller seller) throws Exception {
        Optional<Seller> seller1 = sellerRepo.findByEmail(seller.getEmail());
        if(seller1.isEmpty()){
            throw new Exception("Seller not found.");
        }

        // Check if the password matches
        if (!passwordEncoder.matches(seller.getPassword(), seller1.get().getPassword())) {
            throw new Exception("Invalid password.");
        }

        return seller1.get();  // Return the seller if credentials are valid
    }
}
