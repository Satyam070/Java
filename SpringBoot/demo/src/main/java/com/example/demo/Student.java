package com.example.demo;

import jakarta.persistence.*;

@Entity  // ✔️ Marks this as a database table
@Table(name = "students")
public class Student {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // ✔️ Auto-generates ID
    private Long id;

    private String name;
    private int age;

    // Constructors
    public Student() {}

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
}
