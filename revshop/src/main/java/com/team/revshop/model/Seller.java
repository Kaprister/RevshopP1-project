package com.team.revshop.model;



import jakarta.persistence.*;

@Entity
@Table(name = "sellers")  // Maps this class to the sellers table in the database
public class Seller {

    @Id
    @Column(name = "seller_id")
    private int sellerId;  // Primary Key

    @Column(name = "business_name", nullable = false)
    private String businessName;

    @Column(name = "business_address")
    private String businessAddress;

    // Constructors
    public Seller() {
    }

    public Seller(int sellerId, String businessName, String businessAddress) {
        this.sellerId = sellerId;
        this.businessName = businessName;
        this.businessAddress = businessAddress;
    }

    // Getters and Setters
    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getBusinessAddress() {
        return businessAddress;
    }

    public void setBusinessAddress(String businessAddress) {
        this.businessAddress = businessAddress;
    }

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
