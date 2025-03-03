package com.example.mapper;

import com.example.pojo.EmpExpr;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 员工
 */
@Mapper
public interface EmpExprMapper {
    /**
     * 批量保存员工的工作经历
     */
    void insertBatch(List<EmpExpr> exprList);
}
