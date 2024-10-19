package com.team.revshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SellerController {

    // Display the seller registration form
    @GetMapping("/register/seller")
    public String showSellerRegistrationForm(Model model) {
        return "registerSeller"; // Return the name of the JSP page for seller registration
    }

    // Handle the seller registration submission
    @PostMapping("/register/seller")
    public String registerSeller(@RequestParam String username, @RequestParam String password, Model model) {
        // Logic for registering the seller
        model.addAttribute("message", "Seller registered successfully!");
        return "registrationSuccess"; // Redirect or show a success page
    }
}
