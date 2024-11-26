package models;

import java.util.List;

public class Cart {
    private Long cartId;
    private Long userId;
    private List<Appliance> appliances;
    private double totalAmount;

    // Constructors

    public Cart(Long cartId, Long userId, List<Appliance> appliances, double totalAmount) {
        this.cartId = cartId;
        this.userId = userId;
        this.appliances = appliances;
        this.totalAmount = totalAmount;
    }

    // Getters, and Setters

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<Appliance> getAppliances() {
        return appliances;
    }

    public void setAppliances(List<Appliance> appliances) {
        this.appliances = appliances;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
