package com.team.revshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {

    // Change this mapping to avoid conflict
    @GetMapping("/register/buyer") // This method can stay if it needs to show the registration form
    public String registerBuyer(Model model) {
        // Logic for showing the buyer registration form
        return "buyerRegistration"; // Name of the JSP or view to return
    }

    @PostMapping("/register/buyer") // Add a different mapping for form submission if needed
    public String handleBuyerRegistration(/* params */) {
        // Logic to handle buyer registration
        return "redirect:/registrationSuccess"; // Redirect after successful registration
    }
}
