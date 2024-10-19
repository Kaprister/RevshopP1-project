package com.team.revshop.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.team.revshop.model.Product;
import com.team.revshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/seller/add")
    public ResponseEntity<Product> addProduct(
            @RequestPart("product") String productData,
            @RequestPart("imageFile") MultipartFile imageFile) {
        try {
            // Convert productData (JSON String) to Product object
            ObjectMapper objectMapper = new ObjectMapper();
            Product product = objectMapper.readValue(productData, Product.class);

            // Upload image to Cloudinary and get the URL
            String imageUrl = productService.uploadImageToCloudinary(imageFile);

            // Set the image URL in the product object
            product.setImageUrl(imageUrl);

            // Save the product to the database
            Product savedProduct = productService.addProduct(product);

            return ResponseEntity.ok(savedProduct);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    // List all products by seller ID (using Path Variable)
    @GetMapping("/seller/list/{sellerId}")
    public ResponseEntity<List<Product>> listProductsBySellerId(@PathVariable("sellerId") int sellerId) {
        try {
            List<Product> products = productService.getProductsBySellerId(sellerId);
            return ResponseEntity.ok(products);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

//    List all products from the database
    @GetMapping("/list")
    public ResponseEntity<List<Product>> listAllProducts(){
        try{
            List<Product> products = productService.getAllProducts();
            return ResponseEntity.ok(products);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }


    //Delete product by ID
    @DeleteMapping("seller/delete/{productId}")
    public ResponseEntity<String> deleteProduct(@PathVariable("productId") int productId){
        try{
            productService.deleteProductById(productId);
            return ResponseEntity.ok().body("Product Deleted Successfully!");
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    // Update product by ID
    @PutMapping("seller/update/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable("productId") int productId, @RequestBody Product productDetails) {
        try {
            Product updatedProduct = productService.updateProduct(productId, productDetails);
            return ResponseEntity.ok(updatedProduct);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

}
