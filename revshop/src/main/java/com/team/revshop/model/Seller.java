package com.team.revshop.model;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "sellers")// Maps this class to the sellers table in the database
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Seller {

    @Id
    @Column(name = "seller_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-generate the sellerId
    private int sellerId;  // Primary Key

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "password", unique = true, nullable = false)
    private String password;

    @Column(name = "business_name", nullable = false)
    private String businessName;

    @Column(name = "business_address")
    private String businessAddress;

//    // Constructors
//    public Seller() {
//    }
//
//    public Seller(int sellerId, String businessName, String businessAddress) {
//        this.sellerId = sellerId;
//        this.businessName = businessName;
//        this.businessAddress = businessAddress;
//    }

//    // Getters and Setters
//    public int getSellerId() {
//        return sellerId;
//    }
//
//    public void setSellerId(int sellerId) {
//        this.sellerId = sellerId;
//    }
//
//    public String getBusinessName() {
//        return businessName;
//    }
//
//    public void setBusinessName(String businessName) {
//        this.businessName = businessName;
//    }
//
//    public String getBusinessAddress() {
//        return businessAddress;
//    }
//
//    public void setBusinessAddress(String businessAddress) {
//        this.businessAddress = businessAddress;
//    }

    // Override toString method for easy logging or debugging
    
    
    @Override
    public String toString() {
        return "Seller{" +
                "sellerId=" + sellerId +
                ", businessName='" + businessName + '\'' +
                ", businessAddress='" + businessAddress + '\'' +
                '}';
    }

	
}
