package com.example.bai_thi_thuc_hanh_md3.Service.impl;

import com.example.bai_thi_thuc_hanh_md3.DAO.IStudentDAO;
import com.example.bai_thi_thuc_hanh_md3.DAO.impl.ClassroomDAO;
import com.example.bai_thi_thuc_hanh_md3.DAO.impl.StudentDAO;
import com.example.bai_thi_thuc_hanh_md3.Model.Student;
import com.example.bai_thi_thuc_hanh_md3.Service.IStudent;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.List;

public class StudentService implements IStudent {
    private static StudentService studentService;
    public static StudentService getInstance(){
        if (studentService == null) {
            studentService = new StudentService();
        } return  studentService;
    }

    @Override
    public List<Student> findAll() {
        return StudentDAO.getStudentDAO().findAll();
    }

    @Override
    public Student findOne(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        return StudentDAO.getStudentDAO().findOne(id);
    }

    @Override
    public void create(HttpServletRequest request) {
        String name = request.getParameter("name");
        LocalDate dob = LocalDate.parse(request.getParameter("dob"));
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        int idClass = Integer.parseInt(request.getParameter("class"));
        Student student = new Student(name,dob,address,phone,email,ClassroomDAO.getInstance().findOne(idClass));
        StudentDAO.getStudentDAO().create(student);
    }

    @Override
    public void update(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        LocalDate dob = LocalDate.parse(request.getParameter("dob"));
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        int idClass = Integer.parseInt(request.getParameter("class"));
        Student student = new Student(id,name,dob,address,phone,email,ClassroomDAO.getInstance().findOne(idClass));
        StudentDAO.getStudentDAO().update(student);
    }

    @Override
    public void delete(HttpServletRequest request) {
    int id = Integer.parseInt(request.getParameter("id"));
    StudentDAO.getStudentDAO().delete(id);
    }
    public List<Student> searchByName(HttpServletRequest request) {
        String name = request.getParameter("search");
        return StudentDAO.getStudentDAO().searchByName(name);
    }
}
