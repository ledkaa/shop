package myApp.models;

    import java.util.Date;
import java.util.List;

    public class Order {
        private Long orderId;
        private Long userId;
        private List<Appliance> appliances;
        private Date orderDate;
        private String status;
        private double totalAmount;

        // Constructor

        public Order(Long orderId, Long userId, List<Appliance> appliances, Date orderDate,
                     String status, double totalAmount) {
            this.orderId = orderId;
            this.userId = userId;
            this.appliances = appliances;
            this.orderDate = orderDate;
            this.status = status;
            this.totalAmount = totalAmount;
        }

        // Getters, and Setters


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

        public List<Appliance> getAppliances() {
            return appliances;
        }

        public void setAppliances(List<Appliance> appliances) {
            this.appliances = appliances;
        }

        public Date getOrderDate() {
            return orderDate;
        }

        public void setOrderDate(Date orderDate) {
            this.orderDate = orderDate;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public double getTotalAmount() {
            return totalAmount;
        }

        public void setTotalAmount(double totalAmount) {
            this.totalAmount = totalAmount;
        }
    }

