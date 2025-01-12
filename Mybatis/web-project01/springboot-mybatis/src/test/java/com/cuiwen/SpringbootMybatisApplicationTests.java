package com.cuiwen;

import com.cuiwen.mapper.StudentMapper;
import com.cuiwen.pojo.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringbootMybatisApplicationTests {
    @Autowired
    private StudentMapper studentMapper;

    @Test
    public void testFindAll() {
        List<Student> studentList = studentMapper.findAll();
        studentList.forEach(System.out::println);
    }

    @Test
    public void testDeleteById() {
        studentMapper.deleteById(1);
    }

    @Test
    public void testInsert() {
        Student student = new Student(null, "漼雯", "242241807202");
        studentMapper.insert(student);
    }

    @Test
    public void testUpdate() {
        Student student = new Student(34, null, "242241807206");
        studentMapper.update(student);
    }

    @Test
    public void testFindById() {
        Student student = studentMapper.findById(34);
        System.out.println(student);
    }
}
