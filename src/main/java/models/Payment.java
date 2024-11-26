package models;

public class Payment {
    private Long paymentId;
    private Long orderId;
    private Long userId;
    private String paymentMethod;
    private String paymentStatus;
    private double amountPaid;

    // Constructors

    public Payment(Long paymentId, Long orderId, Long userId, String paymentMethod,
                   String paymentStatus, double amountPaid) {
        this.paymentId = paymentId;
        this.orderId = orderId;
        this.userId = userId;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
        this.amountPaid = amountPaid;
    }

    // Getters, and Setters

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }
}
