package com.example.bai_thi_thuc_hanh_md3.DAO.impl;

import com.example.bai_thi_thuc_hanh_md3.DAO.IClassroomDAO;
import com.example.bai_thi_thuc_hanh_md3.Model.Classroom;
import com.example.bai_thi_thuc_hanh_md3.MyConnection.MyConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ClassroomDAO implements IClassroomDAO {
    private final String SELECT_ALL = "select * from classroom;";
    private final String SELECT_BY_ID = "select * from classroom where id = ?;";

    private static ClassroomDAO classroomDAO;
    public static ClassroomDAO getInstance(){
        if (classroomDAO == null) {
            classroomDAO = new ClassroomDAO();
        }
        return classroomDAO;
    }
    @Override
    public List<Classroom> findAll() {
        List<Classroom> classrooms = new ArrayList<>();
        try (PreparedStatement preparedStatement = MyConnection.getInstance().prepareStatement(SELECT_ALL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                classrooms.add(new Classroom(id, name));
            }
        } catch (SQLException e) {
            e.getStackTrace();
        }
        return classrooms;
    }

    @Override
    public Classroom findOne(int id) {
        Classroom classroom = null;
        try (PreparedStatement preparedStatement = MyConnection.getInstance().prepareStatement(SELECT_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idDB = resultSet.getInt("id");
                String name = resultSet.getString("name");
                classroom = new Classroom(idDB, name);
            }
        } catch (SQLException e) {
            e.getStackTrace();

        }
        return classroom;
    }

    @Override
    public void create(Classroom classroom) {

    }

    @Override
    public void update(Classroom classroom) {

    }

    @Override
    public void delete(int id) {

    }
}
