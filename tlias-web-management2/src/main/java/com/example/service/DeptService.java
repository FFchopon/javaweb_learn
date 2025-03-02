package com.example.service;

import com.example.pojo.Dept;

import java.util.List;

public interface DeptService {
    /**
     * 查询所有部门
     * @return
     */
    List<Dept> findAll();

    void deleteById(Integer id);

    void save(Dept dept);

    Dept getById(Integer id);

    void update(Dept dept);
}
