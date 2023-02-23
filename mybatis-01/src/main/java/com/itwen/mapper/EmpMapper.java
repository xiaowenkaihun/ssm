package com.itwen.mapper;

import com.itwen.pojo.Emp;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface EmpMapper {
    Emp selectEmpById(@Param("empId") int empId);


    /**
     * 查询员工及所对应的部门信息
     * 分步查询的第一步
     * @param empId
     * @return
     */
    Emp selectEmpByIdStepOne(@Param("empId") int empId);


    @Select("select * from t_emp")
    @ResultMap("com.itwen.mapper.EmpMapper.empAndDeptResultMapOne")
    List<Emp> selectAll();


    List<Emp> getDeptAndEmpStepTwo(@Param("deptId") int deptId);

    List<Emp> selectByCondition(@Param("name") String name,
                          @Param("gender") String gender,
                                @Param("age") Integer age,
                                @Param("deptId") Integer deptId);

    List<Emp> selectByConditionTwo(@Param("name") String name,
                                @Param("gender") String gender,
                                @Param("age") Integer age,
                                @Param("deptId") Integer deptId);

    /**
     * 批量添加员工信息
     * @param emps
     */
    void insertMoreEmp(@Param("emps") List<Emp> emps);

    void deleteMoreEmp(@Param("ids") Integer[] ids);
}
