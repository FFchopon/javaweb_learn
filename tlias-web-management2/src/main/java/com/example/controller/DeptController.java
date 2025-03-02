package com.example.controller;

import com.example.pojo.Dept;
import com.example.pojo.Result;
import com.example.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/depts")
@RestController
public class DeptController {

    // private static final Logger logger = LoggerFactory.getLogger(DeptController.class); // 固定的

    @Autowired
    private DeptService deptService;

    // @RequestMapping(value = "/depts", method = RequestMethod.GET)   // method: 指定请求方式
    @GetMapping
    public Result list(){
        // System.out.println("查询全部部门数据");
        log.info("查询全部部门数据");
        List<Dept> deptList = deptService.findAll();
        return Result.success(deptList);
    }

    @DeleteMapping
    public Result delete(Integer id){
        // System.out.println("根据id删除部门，id=" + id);
        log.info("根据id删除部门，{}", id);
        deptService.deleteById(id);
        return Result.success();
    }

    @PostMapping
    public Result save(@RequestBody Dept dept){
        // System.out.println("新增部门, dept=" + dept);
        log.info("新增部门:{}", dept);
        deptService.save(dept);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        // System.out.println("根据ID查询, id=" + id);
        log.info("根据ID查询, id: {}" , id);
        Dept dept = deptService.getById(id);
        return Result.success(dept);
    }

    @PutMapping
    public Result update(@RequestBody Dept dept){
        // System.out.println("修改部门, dept=" + dept);
        log.info("修改部门, dept: {}" , dept);
        deptService.update(dept);
        return Result.success();
    }

}
