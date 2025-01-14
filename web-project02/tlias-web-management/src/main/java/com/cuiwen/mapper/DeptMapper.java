package com.cuiwen.mapper;

import com.cuiwen.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

// Mybatis的持久层(Dao)接口规范一般都叫 XxxMapper
@Mapper
public interface DeptMapper {
    /**
     * 查询所有部门数据，按更新时间降序排序
     * @return 返回部门信息列表
     */
    @Select("select id, name, create_time, update_time from dept order by update_time desc")
    List<Dept> findAll();
    /*
    这种方式使得 MyBatis 能够直接根据注解中的 SQL 语句来执行查询操作，无需额外的 XML 配置。
    MyBatis 会自动解析注解中的 SQL 语句，并将其与接口方法关联起来，当调用 findAll() 方法时，就会执行该SQL语句并返回结果。
     */

    /**
     * 根据部门id删除部门数据
     * @param id 部门id
     */
    @Delete("delete from dept where id = #{id}")
    void deleteById(Integer id);

    /**
     * 插入新的部门数据
     * @param dept 待插入的部门对象
     */
    @Insert("insert into dept(name, create_time, update_time) values(#{name},#{createTime},#{updateTime})")
    void insert(Dept dept);

    /**
     * 根据部门id查询部门详细信息
     * @param id 部门id
     * @return 返回对应的部门对象，若不存在则返回null
     */
    @Select("select * from dept where id = #{id}")
    Dept getById(Integer id);

    /**
     * 更新部门信息，包括部门名称和更新时间
     * @param dept 待更新的部门对象
     */
    @Update("update dept set name = #{name}, update_time = #{updateTime} where id = #{id}")
    void update(Dept dept);
}