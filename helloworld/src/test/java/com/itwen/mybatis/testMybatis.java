package com.itwen.mybatis;

import com.itwen.mapper.UserMapper;
import com.itwen.pojo.User;
import com.itwen.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class testMybatis {
    @Test
    public void testInsert() throws IOException {
        // 获取核心文件的输入流
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        // 获取SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(resourceAsStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

         int i = mapper.insertUser();

        // 使用原始方式
        /*int i = sqlSession.insert("com.itwen.mapper.UserMapper.insertUser");*/

        sqlSession.commit();

        sqlSession.close();

        System.out.println(i);
    }

    @Test
    public void testUpdate(){
        SqlSessionUtil sqlSessionUtil = new SqlSessionUtil();
        SqlSessionFactory sqlSessionFactory = sqlSessionUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int i = mapper.updateUser();
        sqlSession.close();
        if(i==1){
            System.out.println("修改成功");
        }
    }

    @Test
    public void selectAll(){
        SqlSessionUtil sqlSessionUtil = new SqlSessionUtil();
        SqlSessionFactory sqlSessionFactory = sqlSessionUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.selectAll();

        sqlSession.close();
        System.out.println(users);
    }
}
