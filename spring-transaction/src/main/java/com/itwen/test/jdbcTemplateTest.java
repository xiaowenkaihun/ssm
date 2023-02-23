package com.itwen.test;

import com.itwen.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 作者：小温小温今天开荤
 * 日期：2022/10/22 16:43
 * 文件描述：
 */
// 此时我们可以通过注入的方式直接获取IOC中的bean
@RunWith(SpringJUnit4ClassRunner.class)
// 设置spring测试环境配置文件
@ContextConfiguration("classpath:applicationContext.xml")

public class jdbcTemplateTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Test
    public void testJdbcTemplateAdd(){
        String sql = "insert into t_user values(null,?,?,?,?,?)";
        jdbcTemplate.update(sql,"wen", "123", 21, "男", "208345702@qq.com");
    }

    @Test
    public void testJdbcTemplateSelectOne(){
        String sql = "select * from t_user where id = ?";
        User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), 1);
        System.out.println(user);
    }

    @Test
    public void testJdbcTemplateSelectAll(){
        String sql = "select * from t_user";
        List<User> user = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
        user.forEach(System.out::println);
    }

    @Test
    public void testJdbcTemplateCount(){
        String sql = "select count(*) from t_user";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println(count);
    }

}
