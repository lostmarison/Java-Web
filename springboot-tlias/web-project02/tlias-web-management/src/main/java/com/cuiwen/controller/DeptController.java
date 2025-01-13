// Controller层，负责接收前端发起的请求，并调用service查询部门数据，然后响应结果。
package com.cuiwen.controller;

import com.cuiwen.pojo.Dept;
import com.cuiwen.pojo.Result;
import com.cuiwen.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/depts")
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @GetMapping // 1.接受请求
    public Result list() {
        System.out.println("查询全部部门数据");
        // 2.调用Service层
        List<Dept> deptList = deptService.findAll();
        // 3.响应数据
        return Result.success(deptList);
    }

    @DeleteMapping
    public Result delete(Integer id) { // 请求参数名与形参变量名相同
        System.out.println("根据ID删除部门数据 " + id);
        deptService.deleteById(id);
        return Result.success();
    }

    @PostMapping
    public Result add(@RequestBody Dept dept) {
        System.out.println("新增部门数据 " + dept);
        deptService.add(dept);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        System.out.println("根据ID查询部门数据 " + id);
        Dept dept = deptService.getById(id);
        return Result.success(dept);
    }

    @PutMapping
    public Result update(@RequestBody Dept dept) {
        System.out.println("修改部门数据 " + dept);
        deptService.update(dept);
        return Result.success();
    }
}
