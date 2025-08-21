package com.learning_management_service.Udemy_Lite.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name="id")
    private int id;

    @Column(name="student_firstName",nullable = false)
    private String firstName;

    @Column(name="student_lastName",nullable = false)
    private String lastName;

    @Column(name="email",nullable = false, unique = true)
    private String email;

    @Column(name="dob",nullable = false)
    private String dob;

    @Column(name="mobile_no",nullable = false,unique = true)
    private String moblieNo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getMoblieNo() {
        return moblieNo;
    }

    public void setMoblieNo(String moblieNo) {
        this.moblieNo = moblieNo;
    }
}
