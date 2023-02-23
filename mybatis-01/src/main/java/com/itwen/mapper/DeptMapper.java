package com.itwen.mapper;

import com.itwen.pojo.Dept;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DeptMapper {
    List<Dept> selectAll();

    /**
     * 通过分步查询员工及对应的部门信息第二步
     * 先查到了所有的员工信息
     * 但是员工信息的dept属性是空的
     * 所以需要第这一步通过员工中的dept_id查对应的部门
     * 然后再回填
     * 这样就完成了所有员工及对应的部门信息查询
     * 在多表查询，特别是表的数量很多的时候
     * 使用分布查询
     * @param deptId
     * @return
     */
    Dept getEmpAndDeptStepTwo(@Param("deptId") int deptId);


    /**
     * 查询部门信息
     * 部分所含有的所有员工信息
     * @param deptId
     * @return
     */
    Dept getDeptAndEmpByDeptId(@Param("deptId") int deptId);


    Dept getDeptAndEmpStepOne(@Param("deptId") int deptId);
}
