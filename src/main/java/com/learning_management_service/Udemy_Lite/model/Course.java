package com.learning_management_service.Udemy_Lite.model;

import jakarta.persistence.*;

@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="title", nullable = false)
    private String title;

    @Column(name="description", nullable = false)
    private String description;

    @Column(name="category", nullable = false)
    private String category;

    @Column(name="rating")
    private Double rating;

    @Column(name="author_id", nullable = false)
    private String authorId;

    @Column(name="price", nullable = false)
    private Double price;

    @Column(name="country", nullable = false)
    private String country;

    @Column(name="view_count")
    private Long viewCount;



    // --- Getters and Setters ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public Double getRating() { return rating; }
    public void setRating(Double rating) { this.rating = rating; }

    public String getAuthorId() { return authorId; }
    public void setAuthorId(String authorId) { this.authorId = authorId; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    public Long getViewCount() { return viewCount; }
    public void setViewCount(Long viewCount) { this.viewCount = viewCount; }

}