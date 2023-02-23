package com.itwen.mapper;

import com.itwen.pojo.Emp;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface EmpMapper {

    Emp getEmpById(@Param("empId") Integer empId);

}
