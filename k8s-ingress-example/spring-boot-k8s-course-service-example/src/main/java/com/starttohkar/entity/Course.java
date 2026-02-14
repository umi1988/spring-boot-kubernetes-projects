package com.starttohkar.entity;

public class Course {
    private String courseId;
    private String name;
    private double price;

    public Course() {
    }

    public Course(String courseId, String name, double price) {
        this.courseId = courseId;
        this.name = name;
        this.price = price;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
