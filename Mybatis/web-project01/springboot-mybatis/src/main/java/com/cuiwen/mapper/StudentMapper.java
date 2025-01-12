package com.cuiwen.mapper;

import com.cuiwen.pojo.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentMapper {
    /**
     * 查询所有学生
     */
    // @Select("select class_id, name, student_id from student")
    public List<Student> findAll();

    /**
     * 根据classId删除学生
     */
    @Delete("delete from student where class_id = #{classId}")
    public void deleteById(Integer classId);
    // public Integer deleteById(Integer classId); 获取影响的记录数

    /**
     * 新增学生
     * @param student 给定新增的学生信息
     */
    @Insert("insert into student(name, student_id) values(#{name}, #{studentId})")
    public void insert(Student student);

    /**
     * 根据classID修改学生信息
     * @param student 给定修改的学生信息
     */
    @Update("update student set student_id = #{studentId} where class_id = #{classId}")
    public void update(Student student);

    /**
     * 根据classID查询学生信息
     * @param classId 给定查询的classID
     * @return 返回查询到的学生信息
     */
    @Select("select class_id, name, student_id from student where class_id = #{classId}")
    // public Student findById(@Param("classId") Integer classId);
    public Student findById(Integer classId);
}
