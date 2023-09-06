package com.example.bai_thi_thuc_hanh_md3.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface IGenerate <E>{
    List<E> findAll();
    E findOne(HttpServletRequest request);
    void create(HttpServletRequest request);
    void update(HttpServletRequest request);
    void delete(HttpServletRequest request);
}
