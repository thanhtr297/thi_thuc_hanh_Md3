package com.example.bai_thi_thuc_hanh_md3.Model;

import java.time.LocalDate;

public class Student {
    private int id;
    private String name;
    private LocalDate dob;
    private String address;
    private String phoneNumber;
    private String email;
    private Classroom classroom;

    public Student(String name, LocalDate dob, String address, String phoneNumber, String email, Classroom classroom) {
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.classroom = classroom;
    }

    public Student(int id, String name, LocalDate dob, String address, String phoneNumber, String email, Classroom classroom) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.classroom = classroom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }
}
