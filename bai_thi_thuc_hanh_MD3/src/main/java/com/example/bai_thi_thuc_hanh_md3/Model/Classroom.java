package com.example.bai_thi_thuc_hanh_md3.Model;

public class Classroom {
    private int id;
    private String className;

    public Classroom(int id, String className) {
        this.id = id;
        this.className = className;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setName(String name) {
        this.className = name;
    }
}
