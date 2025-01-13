package com.cuiwen.service;

import com.cuiwen.pojo.Dept;

import java.util.List;

/**
 * DeptService接口，定义了与部门相关的业务操作方法
 */
public interface DeptService {
    /**
     * 查询所有部门信息
     * @return 返回部门信息列表
     */
    List<Dept> findAll();

    /**
     * 根据部门id删除部门
     * @param id 部门id
     */
    void deleteById(Integer id);

    /**
     * 添加部门信息
     * @param dept 待添加的部门对象
     */
    void add(Dept dept);

    /**
     * 根据部门id查询部门信息
     * @param id 部门id
     * @return 返回对应的部门对象，若不存在则返回null
     */
    Dept getById(Integer id);

    /**
     * 更新部门信息
     * @param dept 待更新的部门对象
     */
    void update(Dept dept);
}
