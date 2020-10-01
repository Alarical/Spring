package com.itheima.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class JdbcCurdTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void updateTest(){
        jdbcTemplate.update("update test_mysql set money=? where name=?", 10000,"tom");
    }
}
