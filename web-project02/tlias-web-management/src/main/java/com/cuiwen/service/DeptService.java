package com.cuiwen.service;

import com.cuiwen.pojo.Dept;

import java.util.List;

/**
 * 部门业务层接口，定义与部门相关的业务操作
 */
public interface DeptService {
    /**
     * 查询所有部门信息
     * @return 返回部门信息列表
     */
    List<Dept> findAll();

    /**
     * 根据部门id删除部门信息
     * @param id 部门id
     */
    void deleteById(Integer id);

    /**
     * 添加部门信息
     * @param dept 部门对象，包含部门信息
     */
    void insert(Dept dept);

    /**
     * 根据部门id查询部门信息
     * @param id 部门id
     * @return 返回对应的部门对象
     */
    Dept getById(Integer id);

    /**
     * 更新部门信息
     * @param dept 部门对象，包含更新后的部门信息
     */
    void update(Dept dept);
}