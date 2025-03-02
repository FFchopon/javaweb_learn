package com.example.mapper;

import com.example.pojo.Emp;
import com.example.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 员工信息
 */

@Mapper
public interface EmpMapper {

    /**
     * 查询总记录数
     */
    @Select("select count(*) from emp e left join dept d on e.dept_id = d.id ")
    public Long count();

    /**
     * 分页查询
     */
//    @Select("select e.*, d.name deptName from emp as e left join dept as d on e.dept_id = d.id order by update_time desc limit #{start}, #{pageSize}")
    public List<Emp> list(EmpQueryParam empQueryParam);

}
