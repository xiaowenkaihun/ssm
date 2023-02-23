package com.itwen;


import com.itwen.mapper.EmpMapper;
import com.itwen.pojo.Emp;
import com.itwen.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;

public class TestMybatisCache {
    @Test
    /**
     * 执行了一个sql，说明第一次是从数据库查到的
     * 第二次是在缓存里面查询的
     * 这是sqlSession的一级缓存（一定是同一个sqlSession，查询相同的数据）
     */
    public void testGetEmpById(){
        SqlSessionUtil sqlSessionUtil = new SqlSessionUtil();
        SqlSessionFactory sqlSessionFactory = sqlSessionUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp1 = mapper.getEmpById(2);
        System.out.println(emp1);
        /*此方式清空缓存，sqlSession缓存失效*/
        sqlSession.clearCache();
        Emp emp2 = mapper.getEmpById(2);
        System.out.println(emp2);
    }
    @Test
    public void testGetEmpByIdCache(){
        SqlSessionUtil sqlSessionUtil = new SqlSessionUtil();
        SqlSessionFactory sqlSessionFactory = sqlSessionUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp1 = mapper.getEmpById(2);
        System.out.println(emp1);
        /*此方式清空缓存，sqlSession缓存失效*/
        Emp emp2 = mapper.getEmpById(2);
        System.out.println(emp2);
    }


}
