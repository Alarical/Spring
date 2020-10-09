package com.itheima.test;

import com.itheima.domain.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class JdbcCurdTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void updateTest(){
        jdbcTemplate.update("update test_mysql set money=? where name=?", 10000,"tom");
    }

    @Test
    public void getQueryAll(){
        List<Account> accountList = jdbcTemplate.query("select * from test_mysql", new BeanPropertyRowMapper<Account>(Account.class));
        System.out.println(accountList);
    }

}
