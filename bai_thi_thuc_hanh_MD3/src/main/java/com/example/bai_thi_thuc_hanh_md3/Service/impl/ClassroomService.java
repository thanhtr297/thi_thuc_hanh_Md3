package com.example.bai_thi_thuc_hanh_md3.Service.impl;

import com.example.bai_thi_thuc_hanh_md3.DAO.impl.ClassroomDAO;
import com.example.bai_thi_thuc_hanh_md3.DAO.impl.StudentDAO;
import com.example.bai_thi_thuc_hanh_md3.Model.Classroom;
import com.example.bai_thi_thuc_hanh_md3.Model.Student;
import com.example.bai_thi_thuc_hanh_md3.Service.IClassroom;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ClassroomService implements IClassroom {
    private static ClassroomService classroomService;

    public static ClassroomService getInstance() {
        if (classroomService == null) {
            classroomService = new ClassroomService();
        }
        return classroomService;
    }

    @Override
    public List<Classroom> findAll() {
        return ClassroomDAO.getInstance().findAll();
    }

    @Override
    public Classroom findOne(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        return ClassroomDAO.getInstance().findOne(id);
    }

    @Override
    public void create(HttpServletRequest request) {

    }

    @Override
    public void update(HttpServletRequest request) {

    }

    @Override
    public void delete(HttpServletRequest request) {

    }
}
