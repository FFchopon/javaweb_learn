package com.example.service.impl;

import com.example.mapper.EmpMapper;
import com.example.pojo.Emp;
import com.example.pojo.EmpQueryParam;
import com.example.pojo.PageResult;
import com.example.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Override
    public PageResult<Emp> page(EmpQueryParam empQueryParam) {
        // 1. 调用mapper接口，查询总记录数
        Long total = empMapper.count();

        // 2. 调用mapper接口，查询结果列表
        Integer start = (empQueryParam.getPage() - 1) * empQueryParam.getPageSize();
        List<Emp> rows = empMapper.list(empQueryParam);

        // 3. 封装结果
        return new PageResult<Emp>(total, rows);
    }
}
