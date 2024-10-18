package com.team.revshop.model;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "favorites")
public class Favourite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment for favorite_id
    @Column(name = "favorite_id")
    private int favoriteId;

    @Column(name = "user_id", nullable = false)
    private int userId;

    @Column(name = "product_id", nullable = false)
    private int productId;

    @Column(name = "added_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp addedAt;

    // Constructors
    public Favourite() {
    }

    public Favourite(int favoriteId, int userId, int productId, Timestamp addedAt) {
        this.favoriteId = favoriteId;
        this.userId = userId;
        this.productId = productId;
        this.addedAt = addedAt;
    }

    // Getters and Setters
    public int getFavoriteId() {
        return favoriteId;
    }

    public void setFavoriteId(int favoriteId) {
        this.favoriteId = favoriteId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public Timestamp getAddedAt() {
        return addedAt;
    }

    public void setAddedAt(Timestamp addedAt) {
        this.addedAt = addedAt;
    }

    // Override toString method for easy logging or debugging
    @Override
    public String toString() {
        return "Favourite{" +
                "favoriteId=" + favoriteId +
                ", userId=" + userId +
                ", productId=" + productId +
                ", addedAt=" + addedAt +
                '}';
    }
}
