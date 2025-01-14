package com.cuiwen.mapper;

import com.cuiwen.pojo.Emp;
import com.cuiwen.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {
    // ================================= 原始分压查询 =======================================
    /*
    @Select("select count(0) from emp e left join dept d on e.dept_id = d.id")
    public Long countTotal();

    @Select("select e.*, d.name deptName from emp e left join dept d on e.dept_id = d.id " +
            "order by e.update_time desc limit #{start},#{pageSize}")
    public List<Emp> list(Integer start,Integer pageSize);
    */

    // public List<Emp> list(String name, Integer gender, LocalDate begin, LocalDate end);
    public List<Emp> list(EmpQueryParam empQueryParam);


}

