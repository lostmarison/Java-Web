package com.cuiwen.service.impl;

import com.cuiwen.mapper.EmpMapper;
import com.cuiwen.pojo.Emp;
import com.cuiwen.pojo.EmpQueryParam;
import com.cuiwen.pojo.PageResult;
import com.cuiwen.service.EmpService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    /**
     * 原始分页查询
     * @param page 页码
     * @param pageSize 每页记录数
     */
    /*@Override
    public PageResult<Emp> getPage(Integer page, Integer pageSize) {
        // 1. 调用 mapper 接口，查询总记录数
        Long total = empMapper.countTotal();
        // 2. 调用 mapper 接口，查询分页数据（结果列表）
        Integer start = (page - 1) * pageSize;
        List<Emp> rows = empMapper.list(start, pageSize);
        // 3. 封装 PageResult 对象，返回
        return new PageResult<>(total, rows);
    }*/

    /**
     *
     * @param empQueryParam
     * @return
     */
    @Override
    public PageResult<Emp> getPage(EmpQueryParam empQueryParam) {
        // 1. 设置分页参数(PageHelper)
        PageHelper.startPage(empQueryParam.getPage(), empQueryParam.getPageSize());
        // 2. 执行查询
        List<Emp> empList = empMapper.list(empQueryParam);
        // 3. 封装 PageResult 对象，返回
        Page<Emp> p = (Page<Emp>) empList;
        return new PageResult<>(p.getTotal(),p.getResult());
    }

}
