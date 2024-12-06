package myApp.models;

import java.util.Date;

public class Review {
    private Long reviewId;
    private Long userId;
    private Long applianceId;
    private double rating;
    private String comment;
    private Date reviewDate;

    // Constructors

    public Review(Long reviewId, Long userId, Long applianceId, double rating, String comment,
                  Date reviewDate) {
        this.reviewId = reviewId;
        this.userId = userId;
        this.applianceId = applianceId;
        this.rating = rating;
        this.comment = comment;
        this.reviewDate = reviewDate;
    }

    // Getters, and Setters

    public Long getReviewId() {
        return reviewId;
    }

    public void setReviewId(Long reviewId) {
        this.reviewId = reviewId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getApplianceId() {
        return applianceId;
    }

    public void setApplianceId(Long applianceId) {
        this.applianceId = applianceId;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(Date reviewDate) {
        this.reviewDate = reviewDate;
    }
}
