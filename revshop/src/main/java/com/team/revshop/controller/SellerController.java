package com.team.revshop.controller;

import com.team.revshop.model.Seller;
import com.team.revshop.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/seller")
public class SellerController {
    @Autowired
    private SellerService sellerService;

    @PostMapping("/signup")
    public ResponseEntity<Seller> signUp(@RequestBody Seller seller){
        try {
            Seller registeredSeller = sellerService.signUp(seller);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(registeredSeller);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<Seller> login(@RequestBody Seller seller){
        try{
            Seller loggedInSeller = sellerService.login(seller);
            return ResponseEntity.status(HttpStatus.OK)
            .body(loggedInSeller); // Return the custom response object

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}
