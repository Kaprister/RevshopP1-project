package com.team.revshop.controller;

import com.team.revshop.model.Buyer;
import com.team.revshop.model.Seller;
import com.team.revshop.service.BuyerService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/buyer")
public class BuyerController {

    @Autowired
    private BuyerService buyerService;

    @PostMapping("/signup")
    public ResponseEntity<Buyer> signUp(@RequestBody Buyer buyer){
        try{
            Buyer registerdBuyer = buyerService.signUp(buyer);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(registerdBuyer);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<Buyer> login(@RequestBody Buyer buyer, HttpSession session){
        try{
            Buyer loggedInBuyer = buyerService.login(buyer);
            session.setAttribute("buyer", loggedInBuyer);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(loggedInBuyer);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}
