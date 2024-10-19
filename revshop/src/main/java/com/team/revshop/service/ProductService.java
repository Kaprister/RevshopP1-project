package com.team.revshop.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.team.revshop.model.Product;
import com.team.revshop.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private Cloudinary cloudinaryConfig;

//    upload image to cloudinary
    public String uploadImageToCloudinary(MultipartFile imageFile) throws IOException {
        Map uploadResult = cloudinaryConfig.uploader().upload(imageFile.getBytes(), ObjectUtils.emptyMap());
        return uploadResult.get("url").toString();
    }

    // Save product to the database
    public Product addProduct(Product product) {
        return productRepo.save(product);
    }

    // Method to get products by seller ID
    public List<Product> getProductsBySellerId(int sellerId) {
        return productRepo.findBySellerId(sellerId);
    }

//    Method to get all products
    public List<Product> getAllProducts(){
        return productRepo.findAll();
    }

    // Method to delete a product by ID
    public void deleteProductById(int productId) {
        if(productRepo.existsById(productId)){
            productRepo.deleteById(productId);
        }else {
            throw new RuntimeException("Product not found with id: " + productId);
        }
    }

    // Method to update a product by ID
    public Product updateProduct(int productId, Product productDetails){
        Optional<Product> productOptional = productRepo.findById(productId);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            product.setProductName(productDetails.getProductName());
            product.setDescription(productDetails.getDescription());
            product.setPrice(productDetails.getPrice());
            product.setDiscountedPrice(productDetails.getDiscountedPrice());
            product.setQuantity(productDetails.getQuantity());
            product.setImageUrl(productDetails.getImageUrl());
            product.setCategory(productDetails.getCategory());
            return productRepo.save(product);
        } else {
            throw new RuntimeException("Product not found with id: " + productId);
        }
    }

}
