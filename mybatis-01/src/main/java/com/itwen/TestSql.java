package com.itwen;

import com.itwen.mapper.EmpMapper;
import com.itwen.pojo.Emp;
import com.itwen.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class TestSql {
    @Test
    public void selectByCondition(){
        SqlSessionUtil sqlSessionUtil = new SqlSessionUtil();
        SqlSessionFactory sqlSessionFactory = sqlSessionUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> emps = mapper.selectByCondition("", "女", null, null);
        System.out.println(emps);

    }
    @Test
    public void selectByConditionTwo(){
        SqlSessionUtil sqlSessionUtil = new SqlSessionUtil();
        SqlSessionFactory sqlSessionFactory = sqlSessionUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> emps = mapper.selectByConditionTwo("", "女", null, null);
        System.out.println(emps);
    }

    @Test
    public void insertMoreEmp(){
        SqlSessionUtil sqlSessionUtil = new SqlSessionUtil();
        SqlSessionFactory sqlSessionFactory = sqlSessionUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp1 = new Emp(null, "小明1", 23, "男", null);
        Emp emp2 = new Emp(null, "小明2", 24, "男", null);
        Emp emp3 = new Emp(null, "小明3", 25, "男", null);
        List<Emp> emps = Arrays.asList(emp1, emp2, emp3);
        mapper.insertMoreEmp(emps);
    }

    @Test
    public void deleteMoreEmp(){
        SqlSessionUtil sqlSessionUtil = new SqlSessionUtil();
        SqlSessionFactory sqlSessionFactory = sqlSessionUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Integer[] ids = new Integer[]{5,6,7};
        mapper.deleteMoreEmp(ids);
    }
}
