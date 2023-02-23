package com.itwen.mybatis;

import com.itwen.mapper.DeptMapper;
import com.itwen.mapper.EmpMapper;
import com.itwen.pojo.Dept;
import com.itwen.pojo.Emp;
import com.itwen.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.util.List;

public class testResultMap {
    @Test
    public void testResultMapOne(){
        SqlSessionUtil sqlSessionUtil = new SqlSessionUtil();
        SqlSessionFactory sqlSessionFactory = sqlSessionUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.selectEmpById(1);
        System.out.println(emp);
    }
    @Test
    public void testSelectAll(){
        SqlSessionUtil sqlSessionUtil = new SqlSessionUtil();
        SqlSessionFactory sqlSessionFactory = sqlSessionUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> emps = mapper.selectAll();
        System.out.println(emps);
    }

    @Test
    public void testSelectAllDept(){
        SqlSessionUtil sqlSessionUtil = new SqlSessionUtil();
        SqlSessionFactory sqlSessionFactory = sqlSessionUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        List<Dept> depts = mapper.selectAll();
        System.out.println(depts);
    }


}
