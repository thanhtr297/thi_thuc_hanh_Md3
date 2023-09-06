package com.example.bai_thi_thuc_hanh_md3.DAO;

import java.util.List;

public interface IGenerateDAO <E>{
    List<E> findAll();
    E findOne(int id);
    void create(E e);
    void update(E e);
    void delete(int id);
}
