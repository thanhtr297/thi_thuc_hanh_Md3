package com.example.bai_thi_thuc_hanh_md3.DAO.impl;

import com.example.bai_thi_thuc_hanh_md3.DAO.IStudentDAO;
import com.example.bai_thi_thuc_hanh_md3.Model.Classroom;
import com.example.bai_thi_thuc_hanh_md3.Model.Student;
import com.example.bai_thi_thuc_hanh_md3.MyConnection.MyConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO implements IStudentDAO {
    private final String SELECT_ALL = "select * from student;";
    private final String SELECT_BY_ID = "select * from student where id = ?;";
    private final String INSERT_INTO = "insert into student(name,dob,address,phone,email,classroom) value (?,?,?,?,?,?);";
    private final String UPDATE_BY_ID = "update student set name = ?, dob = ?, address = ?, phone = ?, email = ?, classroom = ? where id = ?;";
    private final String DELETE_BY_ID = "delete from student where id = ?;";
    private final String SELECT_BY_NAME = "select * from student where name like ?";
    private static StudentDAO studentDAO;
    public static StudentDAO getStudentDAO() {
        if (studentDAO == null) {
            studentDAO = new StudentDAO();
        }
        return studentDAO;
    }
    @Override
    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        try (PreparedStatement preparedStatement = MyConnection.getInstance().prepareStatement(SELECT_ALL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                LocalDate dob = resultSet.getObject("dob", LocalDate.class);
                String address = resultSet.getString("address");
                String phone = resultSet.getString("phone");
                String mail = resultSet.getString("email");
                int idClass = resultSet.getInt("classroom");
                students.add(new Student(id, name,dob,address,phone,mail,ClassroomDAO.getInstance().findOne(idClass)));
            }
        } catch (SQLException e) {
            e.getStackTrace();
        }
        return students;
    }

    @Override
    public Student findOne(int id) {
        Student student = null;
        try (PreparedStatement preparedStatement = MyConnection.getInstance().prepareStatement(SELECT_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                LocalDate dob = resultSet.getObject("dob", LocalDate.class);
                String address = resultSet.getString("address");
                String phone = resultSet.getString("phone");
                String mail = resultSet.getString("email");
                int idClass = resultSet.getInt("classroom");
                student = new Student(name,dob,address,phone,mail,ClassroomDAO.getInstance().findOne(idClass));
                student.setId(id);
            }
        } catch (SQLException e) {
            e.getStackTrace();
        }
        return student;
    }

    @Override
    public void create(Student student) {
        try (PreparedStatement preparedStatement = MyConnection.getInstance().prepareStatement(INSERT_INTO)) {
            preparedStatement.setString(1, student.getName());
            preparedStatement.setObject(2,student.getDob());
            preparedStatement.setString(3, student.getAddress());
            preparedStatement.setString(4, student.getPhoneNumber());
            preparedStatement.setString(5, student.getEmail());
            preparedStatement.setInt(6,student.getClassroom().getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.getStackTrace();
        }
    }

    @Override
    public void update(Student student) {
        try (PreparedStatement preparedStatement = MyConnection.getInstance().prepareStatement(UPDATE_BY_ID)) {
            preparedStatement.setString(1, student.getName());
            preparedStatement.setObject(2,student.getDob());
            preparedStatement.setString(3, student.getAddress());
            preparedStatement.setString(4, student.getPhoneNumber());
            preparedStatement.setString(5, student.getEmail());
            preparedStatement.setInt(6,student.getClassroom().getId());
            preparedStatement.setInt(7,student.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.getStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try (PreparedStatement preparedStatement = MyConnection.getInstance().prepareStatement(DELETE_BY_ID)) {
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.getStackTrace();
        }
    }
    public List<Student> searchByName(String name) {
        List<Student> students = new ArrayList<>();
        try (PreparedStatement preparedStatement = MyConnection.getInstance().prepareStatement(SELECT_BY_NAME)) {
            preparedStatement.setString(1,'%'+name+'%');
            preparedStatement.executeQuery();
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nameDB = resultSet.getString("name");
                LocalDate dob = resultSet.getObject("dob", LocalDate.class);
                String address = resultSet.getString("address");
                String phone = resultSet.getString("phone");
                String mail = resultSet.getString("email");
                int idClass = resultSet.getInt("classroom");
                students.add(new Student(id, nameDB,dob,address,phone,mail,ClassroomDAO.getInstance().findOne(idClass)));
            }
        } catch (SQLException e) {
            e.getStackTrace();
        }
        return students;
    }
}
