package com.learning_management_service.Udemy_Lite.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "enrollment")
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Many enrollments can belong to one user
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // Many enrollments can belong to one course
    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    // Extra metadata
    @Column(name = "enrolled_at", nullable = false)
    private LocalDateTime enrolledAt;

    @Column(name = "progress")
    private Double progress;   // optional: 0–100 %

    @Column(name = "status")
    private String status;     // e.g., "ENROLLED", "COMPLETED"

    // --- Constructors ---

    public Enrollment(User user, Course course) {
        this.user = user;
        this.course = course;
        this.enrolledAt = LocalDateTime.now();
        this.status = "ENROLLED";
        this.progress = 0.0;
    }

    // --- Getters and Setters ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public Course getCourse() { return course; }
    public void setCourse(Course course) { this.course = course; }

    public LocalDateTime getEnrolledAt() { return enrolledAt; }
    public void setEnrolledAt(LocalDateTime enrolledAt) { this.enrolledAt = enrolledAt; }

    public Double getProgress() { return progress; }
    public void setProgress(Double progress) { this.progress = progress; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}