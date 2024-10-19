package com.team.revshop.service;

import com.team.revshop.model.Buyer;
import com.team.revshop.repository.BuyerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BuyerService {
    @Autowired
    private BuyerRepo buyerRepo;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    // buyer signup feature
    public Buyer signUp(Buyer buyer) throws Exception {
        // check if buyer is already present
        Optional<Buyer> existingBuyer = buyerRepo.findByEmail(buyer.getEmail());
        if (existingBuyer.isPresent()) {
            throw new IllegalArgumentException("Email already registered!");
        }

        // Encrypt the password before saving
        buyer.setPassword(passwordEncoder.encode(buyer.getPassword()));

        // Save the buyer to the database
        return buyerRepo.save(buyer);
    }

    public Buyer login(Buyer buyer) throws Exception {
        Optional<Buyer> buyer1 = buyerRepo.findByEmail(buyer.getEmail());
        if(buyer1.isEmpty()){
            throw new Exception("Buyer not found.");
        }

//      // check if the password matches
        if(!passwordEncoder.matches(buyer.getPassword(), buyer1.get().getPassword())){
            throw new Exception("Invalid Password!");
        }
        return buyer1.get();

    }
}
