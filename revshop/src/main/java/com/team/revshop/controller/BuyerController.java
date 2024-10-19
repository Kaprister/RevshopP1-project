package com.team.revshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BuyerController {

    // Change this mapping to avoid conflict
    @GetMapping("/buyer/register") // Change this path to something else
    public String showBuyerRegistrationForm(Model model) {
        // Logic for showing the buyer registration form
        return "buyerRegistration"; // Name of the JSP or view to return
    }
}
