package com.example.bai_thi_thuc_hanh_md3.Controller;

import com.example.bai_thi_thuc_hanh_md3.DAO.impl.StudentDAO;
import com.example.bai_thi_thuc_hanh_md3.Model.Classroom;
import com.example.bai_thi_thuc_hanh_md3.Model.Student;
import com.example.bai_thi_thuc_hanh_md3.Service.impl.ClassroomService;
import com.example.bai_thi_thuc_hanh_md3.Service.impl.StudentService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentServlet", value = "/student-servlet")
public class StudentServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "":
                listStudent(request, response);
                break;
            case "create":
                createGetStudent(request, response);
                break;
            case "update":
                updateGetStudent(request, response);
                break;
            case "delete":
                deleteProduct(request, response);
                break;
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createPostStudent(request, response);
                break;
            case "update":
                updatePostStudent(request, response);
                break;
            case "searchByName":
                searchByName(request,response);
                break;
        }
    }

    private void searchByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> student = StudentService.getInstance().searchByName(request);
        request.setAttribute("list",student);
        RequestDispatcher req = request.getRequestDispatcher("display.jsp");
        req.forward(request,response);
    }

    private void listStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> students = StudentService.getInstance().findAll();
        request.setAttribute("list",students);
        RequestDispatcher req = request.getRequestDispatcher("display.jsp");
        req.forward(request,response);
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
    StudentService.getInstance().delete(request);
    response.sendRedirect("student-servlet");
    }

    private void updateGetStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = StudentDAO.getStudentDAO().findOne(id);
        request.setAttribute("listS", student);
        List<Classroom> classrooms = ClassroomService.getInstance().findAll();
        request.setAttribute("listC", classrooms);
        RequestDispatcher req = request.getRequestDispatcher("update.jsp");
        req.forward(request, response);
    }
    private void updatePostStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
        StudentService.getInstance().update(request);
        response.sendRedirect("student-servlet");
    }
    private void createGetStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    List<Classroom> classrooms = ClassroomService.getInstance().findAll();
    request.setAttribute("listC",classrooms);
    RequestDispatcher req = request.getRequestDispatcher("create.jsp");
    req.forward(request,response);
    }

    private void createPostStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
    StudentService.getInstance().create(request);
    response.sendRedirect("student-servlet");
    }






}