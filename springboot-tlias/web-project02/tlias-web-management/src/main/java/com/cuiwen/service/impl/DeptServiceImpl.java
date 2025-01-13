package com.cuiwen.service.impl;

import com.cuiwen.mapper.DeptMapper;
import com.cuiwen.pojo.Dept;
import com.cuiwen.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * DeptServiceImpl类，实现了DeptService接口，提供了部门相关的具体业务实现
 */
@Service
public class DeptServiceImpl implements DeptService {
    @Autowired // 自动注入DeptMapper对象，用于与数据库进行交互
    private DeptMapper deptMapper;

    /**
     * 查询所有部门信息
     * @return 返回部门信息列表
     */
    @Override
    public List<Dept> findAll() {
        return deptMapper.findAll();
    }

    /**
     * 根据部门id删除部门
     * @param id 部门id
     */
    @Override
    public void deleteById(Integer id) {
        deptMapper.deleteById(id);
    }

    /**
     * 添加部门信息
     * @param dept 待添加的部门对象
     */
    @Override
    public void add(Dept dept) {
        // 设置部门的创建时间和更新时间为当前时间
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        // 调用mapper层的方法将部门信息插入数据库
        deptMapper.insert(dept);
    }

    /**
     * 根据部门id查询部门信息
     * @param id 部门id
     * @return 返回对应的部门对象，若不存在则返回null
     */
    @Override
    public Dept getById(Integer id) {
        return deptMapper.getById(id);
    }

    /**
     * 更新部门信息
     * @param dept 待更新的部门对象
     */
    @Override
    public void update(Dept dept) {
        // 设置部门的更新时间为当前时间
        dept.setUpdateTime(LocalDateTime.now());
        // 调用mapper层的方法更新数据库中的部门信息
        deptMapper.update(dept);
    }
}
