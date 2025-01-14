package com.cuiwen.controller;

import com.cuiwen.pojo.Dept;
import com.cuiwen.pojo.Result;
import com.cuiwen.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 部门控制器，处理与部门相关的 http 请求
 */
@Slf4j
@RequestMapping("/depts")
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    /**
     * 列出所有部门信息
     * @return 返回包含部门信息列表的结果对象
     */
    @GetMapping// 1. 接受请求
    public Result list() {
        log.info("查询全部部门的数据");
        List<Dept> deptList = deptService.findAll(); // 2. 调用Service层
        return Result.success(deptList); // 3. 响应数据
    }

    /*
      1. 实体类属性名和数据库表查询返回的字段名一致，mybatis会自动封装。
      2. 如果实体类属性名和数据库表查询返回的字段名不一致，不能自动封装。
      解决方法：手动结果映射；起别名；开启驼峰命名（推荐）
     */

    /**
     * 根据部门id删除部门信息
     * @param id 部门id
     * @return 返回操作结果对象
     */
    @DeleteMapping
    public Result delete(Integer id) { // 如果请求参数名与形参变量名相同，直接定义方法形参即可接收
        log.info("根据ID删除部门数据: {} ", id);
        deptService.deleteById(id);
        return Result.success();
    }

    /**
     * 添加部门信息
     * @param dept 部门对象，包含部门信息，通过请求体传递
     * @return 返回操作结果对象
     */
    @PostMapping
    public Result add(@RequestBody Dept dept) {
        log.info("新增部门数据: {}", dept);
        deptService.insert(dept);
        return Result.success();
    }

    /**
     * 根据部门id查询部门信息
     * @param id 部门id，通过路径变量传递
     * @return 返回包含部门对象的结果对象
     */
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id) {
        log.info("根据ID查询部门数据: {}", id);
        Dept dept = deptService.getById(id);
        return Result.success(dept);
    }

    /**
     * 更新部门信息
     * @param dept 部门对象，包含更新后的部门信息，通过请求体传递
     * @return 返回操作结果对象
     */
    @PutMapping
    public Result updateInfo(@RequestBody Dept dept) {
        log.info("更新部门数据: {} ", dept);
        deptService.update(dept);
        return Result.success();
    }
}