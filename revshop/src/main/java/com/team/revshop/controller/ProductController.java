package com.team.revshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {

    // Change this mapping to a different URL, for example:
    @GetMapping("/products")
    public String greet() {
        return "productPage"; // Assuming this returns a JSP page for products
    }
}
